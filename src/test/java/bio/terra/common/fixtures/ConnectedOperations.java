package bio.terra.common.fixtures;

import bio.terra.app.configuration.ConnectedTestConfiguration;
import bio.terra.common.TestUtils;
import bio.terra.model.BillingProfileModel;
import bio.terra.model.BillingProfileRequestModel;
import bio.terra.model.BulkLoadArrayRequestModel;
import bio.terra.model.BulkLoadArrayResultModel;
import bio.terra.model.BulkLoadRequestModel;
import bio.terra.model.BulkLoadResultModel;
import bio.terra.model.DRSChecksum;
import bio.terra.model.DRSObject;
import bio.terra.model.DatasetModel;
import bio.terra.model.DatasetRequestModel;
import bio.terra.model.DatasetSummaryModel;
import bio.terra.model.DeleteResponseModel;
import bio.terra.model.ErrorModel;
import bio.terra.model.FileLoadModel;
import bio.terra.model.FileModel;
import bio.terra.model.IngestRequestModel;
import bio.terra.model.IngestResponseModel;
import bio.terra.model.JobModel;
import bio.terra.model.SnapshotModel;
import bio.terra.model.SnapshotRequestModel;
import bio.terra.model.SnapshotSummaryModel;
import bio.terra.service.iam.IamService;
import bio.terra.service.iam.sam.SamConfiguration;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.CoreMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Common code for creating and deleting datasets and snapshots via MockMvc
// and tracking what is created so it can be deleted.
@Component
public class ConnectedOperations {
    private static final Logger logger = LoggerFactory.getLogger(ConnectedOperations.class);

    private MockMvc mvc;
    private JsonLoader jsonLoader;
    private SamConfiguration samConfiguration;
    private Storage storage = StorageOptions.getDefaultInstance().getService();
    private ConnectedTestConfiguration testConfig;

    private boolean deleteOnTeardown;
    private List<String> createdSnapshotIds;
    private List<String> createdDatasetIds;
    private List<String> createdProfileIds;
    private List<String[]> createdFileIds; // [0] is datasetid, [1] is fileid
    private List<String> createdBuckets;
    private List<String> createdScratchFiles;

    @Autowired
    public ConnectedOperations(MockMvc mvc,
                               JsonLoader jsonLoader,
                               SamConfiguration samConfiguration,
                               ConnectedTestConfiguration testConfig) {
        this.mvc = mvc;
        this.jsonLoader = jsonLoader;
        this.samConfiguration = samConfiguration;
        this.testConfig = testConfig;

        createdSnapshotIds = new ArrayList<>();
        createdDatasetIds = new ArrayList<>();
        createdFileIds = new ArrayList<>();
        createdProfileIds = new ArrayList<>();
        deleteOnTeardown = true;
        createdBuckets = new ArrayList<>();
        createdScratchFiles = new ArrayList<>();
    }

    public void stubOutSamCalls(IamService samService) {
        when(samService.createSnapshotResource(any(), any(), any())).thenReturn("hi@hi.com");
        when(samService.isAuthorized(any(), any(), any(), any())).thenReturn(Boolean.TRUE);
        when(samService.createDatasetResource(any(), any())).thenReturn(
            Collections.singletonList(samConfiguration.getStewardsGroupEmail()));
        doNothing().when(samService).deleteSnapshotResource(any(), any());
        doNothing().when(samService).deleteDatasetResource(any(), any());
    }

    /**
     * Creating a dataset through the http layer causes a dataset create flight to run, creating metadata and primary
     * data to be modified.
     *
     * @param resourcePath path to json used for a dataset create request
     * @return summary of the dataset created
     * @throws Exception
     */
    public DatasetSummaryModel createDataset(BillingProfileModel profileModel,
                                             String resourcePath) throws Exception {
        DatasetRequestModel datasetRequest = jsonLoader.loadObject(resourcePath, DatasetRequestModel.class);
        datasetRequest
            .name(Names.randomizeName(datasetRequest.getName()))
            .defaultProfileId(profileModel.getId());

        return createDataset(datasetRequest);
    }

    public DatasetSummaryModel createDataset(DatasetRequestModel datasetRequest) throws Exception {
        MvcResult result = mvc.perform(post("/api/repository/v1/datasets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtils.mapToJson(datasetRequest)))
            .andReturn();
        MockHttpServletResponse response = validateJobModelAndWait(result);
        DatasetSummaryModel datasetSummaryModel = handleSuccessCase(response, DatasetSummaryModel.class);
        addDataset(datasetSummaryModel.getId());
        return datasetSummaryModel;
    }

    public ErrorModel createDatasetExpectError(DatasetRequestModel datasetRequest, HttpStatus expectedStatus)
        throws Exception {
        MvcResult result = mvc.perform(post("/api/repository/v1/datasets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtils.mapToJson(datasetRequest)))
            .andReturn();
        MockHttpServletResponse response = validateJobModelAndWait(result);
        ErrorModel errorModel = handleFailureCase(response, expectedStatus);
        return errorModel;
    }

    public BillingProfileModel createProfileForAccount(String billingAccountId) throws Exception {
        BillingProfileRequestModel profileRequestModel = ProfileFixtures.randomBillingProfileRequest()
            .billingAccountId(billingAccountId);
        return createProfile(profileRequestModel);
    }

    public BillingProfileModel createProfile(BillingProfileRequestModel profileRequestModel) throws Exception {
        MvcResult result = mvc.perform(post("/api/resources/v1/profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtils.mapToJson(profileRequestModel)))
            .andReturn();

        MockHttpServletResponse response = result.getResponse();
        String responseContent = response.getContentAsString();

        if (response.getStatus() == HttpStatus.CREATED.value()) {
            BillingProfileModel billingProfileModel =
                TestUtils.mapFromJson(responseContent, BillingProfileModel.class);
            addProfile(billingProfileModel.getId());
            return billingProfileModel;
        }
        ErrorModel errorModel = TestUtils.mapFromJson(responseContent, ErrorModel.class);
        List<String> errorDetail = errorModel.getErrorDetail();
        String message = String.format("couldn't create profile: %s (%s)",
            errorModel.getMessage(), String.join(", ", errorDetail));
        throw new IllegalArgumentException(message);
    }

    public BillingProfileModel getProfileById(String profileId) throws Exception {
        MvcResult result = mvc.perform(get("/api/resources/v1/profiles/" + profileId)
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        return TestUtils.mapFromJson(result.getResponse().getContentAsString(), BillingProfileModel.class);
    }

    public SnapshotSummaryModel createSnapshot(DatasetSummaryModel datasetSummaryModel,
                                                  String resourcePath,
                                                  String infix) throws Exception {

        SnapshotRequestModel snapshotRequest = jsonLoader.loadObject(resourcePath, SnapshotRequestModel.class);
        String snapshotName = Names.randomizeNameInfix(snapshotRequest.getName(), infix);
        snapshotRequest.setName(snapshotName);

        // TODO: the next two lines assume SingleDatasetSnapshot
        snapshotRequest.getContents().get(0).setDatasetName(datasetSummaryModel.getName());
        snapshotRequest.profileId(datasetSummaryModel.getDefaultProfileId());

        MvcResult result = mvc.perform(post("/api/repository/v1/snapshots")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtils.mapToJson(snapshotRequest)))
            .andReturn();

        MockHttpServletResponse response = validateJobModelAndWait(result);
        SnapshotSummaryModel snapshotSummary = handleCreateSnapshotSuccessCase(response);

        return snapshotSummary;
    }

    public SnapshotModel getSnapshot(String snapshotId) throws Exception {
        MvcResult result = mvc.perform(get("/api/repository/v1/snapshots/" + snapshotId)).andReturn();
        MockHttpServletResponse response = result.getResponse();
        return TestUtils.mapFromJson(response.getContentAsString(), SnapshotModel.class);
    }

    public DatasetModel getDataset(String datasetId) throws Exception {
        MvcResult result = mvc.perform(get("/api/repository/v1/datasets/" + datasetId)).andReturn();
        return handleSuccessCase(result.getResponse(), DatasetModel.class);
    }

    public ErrorModel getDatasetExpectError(String datasetId, HttpStatus expectedStatus) throws Exception {
        MvcResult result = mvc.perform(get("/api/repository/v1/datasets/" + datasetId)).andReturn();
        return handleFailureCase(result.getResponse(), expectedStatus);
    }

    public SnapshotSummaryModel handleCreateSnapshotSuccessCase(MockHttpServletResponse response) throws Exception {
        SnapshotSummaryModel summaryModel = handleSuccessCase(response, SnapshotSummaryModel.class);
        addSnapshot(summaryModel.getId());
        return summaryModel;
    }

    public <T> T handleSuccessCase(MockHttpServletResponse response, Class<T> returnClass) throws Exception {
        String responseBody = response.getContentAsString();
        HttpStatus responseStatus = HttpStatus.valueOf(response.getStatus());
        if (!responseStatus.is2xxSuccessful()) {
            String failMessage = "Request for " + returnClass.getName() +
                " failed: status=" + responseStatus.toString();
            if (StringUtils.contains(responseBody, "message")) {
                // If the responseBody contains the word 'message', then we try to decode it as an ErrorModel
                // so we can generate good failure information.
                ErrorModel errorModel = TestUtils.mapFromJson(responseBody, ErrorModel.class);
                failMessage += " msg=" + errorModel.getMessage();
            } else {
                failMessage += " responseBody=" + responseBody;
            }
            fail(failMessage);
        }

        return TestUtils.mapFromJson(responseBody, returnClass);
    }

    public ErrorModel handleFailureCase(MockHttpServletResponse response) throws Exception {
        return handleFailureCase(response, null);
    }

    public ErrorModel handleFailureCase(MockHttpServletResponse response, HttpStatus expectedStatus)
        throws Exception {
        HttpStatus responseStatus = HttpStatus.valueOf(response.getStatus());

        // check the failure status matches the expected
        // if no specific status is specified, just check that it's not successful
        if (expectedStatus == null) {
            assertFalse("Expect failure", responseStatus.is2xxSuccessful());
        } else {
            assertEquals("Expect specific failure status", expectedStatus, responseStatus);
        }

        String responseBody = response.getContentAsString();
        assertTrue("Error model was returned on failure",
            StringUtils.contains(responseBody, "message"));

        return TestUtils.mapFromJson(responseBody, ErrorModel.class);
    }

    public void deleteTestDataset(String id) throws Exception {
        // We only use this for @After, so we don't check return values
        MvcResult result = mvc.perform(delete("/api/repository/v1/datasets/" + id)).andReturn();
        MockHttpServletResponse response = validateJobModelAndWait(result);
        checkDeleteResponse(response);

    }

    public void deleteTestProfile(String id) throws Exception {
        mvc.perform(delete("/api/resources/v1/profiles/" + id)).andReturn();
        // not checking the response -- it's possible other datasets are using this profile. if we spin up separate
        // databases for these tests it would make it easier to do these types of checks
    }

    public void deleteTestSnapshot(String id) throws Exception {
        MvcResult result = mvc.perform(delete("/api/repository/v1/snapshots/" + id)).andReturn();
        MockHttpServletResponse response = validateJobModelAndWait(result);
        assertThat(response.getStatus(), equalTo(HttpStatus.OK.value()));
        checkDeleteResponse(response);
    }

    public void deleteTestFile(String datasetId, String fileId) throws Exception {
        MvcResult result = mvc.perform(
            delete("/api/repository/v1/datasets/" + datasetId + "/files/" + fileId))
                .andReturn();
        logger.info("deleting datasetId:{} objectId:{}", datasetId, fileId);
        MockHttpServletResponse response = validateJobModelAndWait(result);
        assertThat(response.getStatus(), equalTo(HttpStatus.OK.value()));
        checkDeleteResponse(response);
    }

    public void deleteTestBucket(String bucketName) {
        storage.delete(bucketName);
    }

    public void deleteTestScratchFile(String path) {
        Blob scratchBlob = storage.get(BlobId.of(testConfig.getIngestbucket(), path));
        if (scratchBlob != null) {
            scratchBlob.delete();
        }
    }

    public void checkDeleteResponse(MockHttpServletResponse response) throws Exception {
        HttpStatus status = HttpStatus.valueOf(response.getStatus());
        if (status.is2xxSuccessful()) {
            DeleteResponseModel responseModel =
                TestUtils.mapFromJson(response.getContentAsString(), DeleteResponseModel.class);
            assertTrue("Valid delete response object state enumeration",
                (responseModel.getObjectState() == DeleteResponseModel.ObjectStateEnum.DELETED ||
                    responseModel.getObjectState() == DeleteResponseModel.ObjectStateEnum.NOT_FOUND));
        } else {
            ErrorModel errorModel = handleFailureCase(response, HttpStatus.NOT_FOUND);
            assertNotNull("error model returned", errorModel);
        }
    }

    public IngestResponseModel ingestTableSuccess(
        String datasetId,
        IngestRequestModel ingestRequestModel) throws Exception {

        String jsonRequest = TestUtils.mapToJson(ingestRequestModel);
        String url = "/api/repository/v1/datasets/" + datasetId + "/ingest";

        MvcResult result = mvc.perform(post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonRequest))
            .andReturn();
        MockHttpServletResponse response = validateJobModelAndWait(result);

        IngestResponseModel ingestResponse =
            handleSuccessCase(response, IngestResponseModel.class);
        assertThat("ingest response has no bad rows", ingestResponse.getBadRowCount(), equalTo(0L));

        return ingestResponse;
    }

    public ErrorModel ingestTableFailure(String datasetId, IngestRequestModel ingestRequestModel) throws Exception {
        String jsonRequest = TestUtils.mapToJson(ingestRequestModel);
        String url = "/api/repository/v1/datasets/" + datasetId + "/ingest";
        MvcResult result = mvc.perform(post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonRequest))
            .andReturn();
        MockHttpServletResponse response = validateJobModelAndWait(result);
        return handleFailureCase(response);
    }

    public FileModel ingestFileSuccess(String datasetId, FileLoadModel fileLoadModel) throws Exception {
        String jsonRequest = TestUtils.mapToJson(fileLoadModel);
        String url = "/api/repository/v1/datasets/" + datasetId + "/files";
        MvcResult result = mvc.perform(post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonRequest))
            .andReturn();

        MockHttpServletResponse response = validateJobModelAndWait(result);

        FileModel fileModel = handleSuccessCase(response, FileModel.class);
        assertThat("description matches", fileModel.getDescription(),
            CoreMatchers.equalTo(fileLoadModel.getDescription()));
        assertThat("mime type matches", fileModel.getFileDetail().getMimeType(),
            CoreMatchers.equalTo(fileLoadModel.getMimeType()));

        for (DRSChecksum checksum : fileModel.getChecksums()) {
            assertTrue("valid checksum type",
                (StringUtils.equals(checksum.getType(), "crc32c") ||
                    StringUtils.equals(checksum.getType(), "md5")));
        }

        logger.info("addFile datasetId:{} objectId:{}", datasetId, fileModel.getFileId());
        addFile(datasetId, fileModel.getFileId());

        return fileModel;
    }

    public BulkLoadArrayResultModel ingestArraySuccess(String datasetId,
                                                       BulkLoadArrayRequestModel loadModel) throws Exception {
        MvcResult result = ingestArrayRaw(datasetId, loadModel);
        MockHttpServletResponse response = validateJobModelAndWait(result);
        return handleSuccessCase(response, BulkLoadArrayResultModel.class);
    }

    public ErrorModel ingestArrayFailure(String datasetId, BulkLoadArrayRequestModel loadModel) throws Exception {
        MvcResult result = ingestArrayRaw(datasetId, loadModel);
        MockHttpServletResponse response = validateJobModelAndWait(result);
        return handleFailureCase(response);
    }

    public MvcResult ingestArrayRaw(String datasetId, BulkLoadArrayRequestModel loadModel) throws Exception {
        String jsonRequest = TestUtils.mapToJson(loadModel);
        String url = "/api/repository/v1/datasets/" + datasetId + "/files/bulk/array";
        return mvc.perform(post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonRequest))
            .andReturn();
    }

    public BulkLoadResultModel ingestBulkFileSuccess(String datasetId,
                                                     BulkLoadRequestModel loadModel) throws Exception {
        MvcResult result = ingestBulkFileRaw(datasetId, loadModel);
        MockHttpServletResponse response = validateJobModelAndWait(result);
        return handleSuccessCase(response, BulkLoadResultModel.class);
    }

    public ErrorModel ingestBulkFileFailure(String datasetId, BulkLoadRequestModel loadModel) throws Exception {
        MvcResult result = ingestBulkFileRaw(datasetId, loadModel);
        MockHttpServletResponse response = validateJobModelAndWait(result);
        return handleFailureCase(response);
    }

    public MvcResult ingestBulkFileRaw(String datasetId, BulkLoadRequestModel loadModel) throws Exception {
        String jsonRequest = TestUtils.mapToJson(loadModel);
        String url = "/api/repository/v1/datasets/" + datasetId + "/files/bulk";
        return mvc.perform(post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonRequest))
            .andReturn();
    }

    public ErrorModel ingestFileFailure(String datasetId, FileLoadModel fileLoadModel) throws Exception {
        String jsonRequest = TestUtils.mapToJson(fileLoadModel);
        String url = "/api/repository/v1/datasets/" + datasetId + "/files";
        MvcResult result = mvc.perform(post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonRequest))
            .andReturn();

        MockHttpServletResponse response = validateJobModelAndWait(result);

        return handleFailureCase(response);
    }

    public FileModel lookupSnapshotFile(String snapshotId, String objectId) throws Exception {
        String url = "/api/repository/v1/snapshots/" + snapshotId + "/files/" + objectId;
        MvcResult result = mvc.perform(get(url)
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        return TestUtils.mapFromJson(result.getResponse().getContentAsString(), FileModel.class);
    }

    public FileModel lookupSnapshotFileByPath(String snapshotId, String path, long depth) throws Exception {
        String url = "/api/repository/v1/snapshots/" + snapshotId + "/filesystem/objects";
        MvcResult result = mvc.perform(get(url)
            .param("path", path)
            .param("depth", Long.toString(depth))
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        return TestUtils.mapFromJson(result.getResponse().getContentAsString(), FileModel.class);
    }

    public DRSObject drsGetObjectSuccess(String drsObjectId, boolean expand) throws Exception {
        String url = "/ga4gh/drs/v1/objects/" + drsObjectId;
        MvcResult result = mvc.perform(get(url)
            .param("expand", Boolean.toString(expand))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();

        return TestUtils.mapFromJson(result.getResponse().getContentAsString(), DRSObject.class);
    }

    public MockHttpServletResponse validateJobModelAndWait(MvcResult inResult) throws Exception {
        MvcResult result = inResult;
        while (true) {
            MockHttpServletResponse response = result.getResponse();
            HttpStatus status = HttpStatus.valueOf(response.getStatus());
            assertTrue("expected jobs polling status, got " + status.toString(),
                (status == HttpStatus.ACCEPTED || status == HttpStatus.OK));

            JobModel jobModel = TestUtils.mapFromJson(response.getContentAsString(), JobModel.class);
            String jobId = jobModel.getId();
            String locationUrl = response.getHeader("Location");
            assertNotNull("location URL was specified", locationUrl);

            switch (status) {
                case ACCEPTED:
                    // Not done case: sleep and probe using the header URL
                    assertThat("location header for probe", locationUrl,
                        equalTo(String.format("/api/repository/v1/jobs/%s", jobId)));

                    TimeUnit.SECONDS.sleep(1);
                    result = mvc.perform(get(locationUrl).accept(MediaType.APPLICATION_JSON)).andReturn();
                    break;

                case OK:
                    // Done case: get the result with the header URL and return the response;
                    // let the caller interpret the response
                    assertThat("location header for result", locationUrl,
                        equalTo(String.format("/api/repository/v1/jobs/%s/result", jobId)));
                    result = mvc.perform(get(locationUrl).accept(MediaType.APPLICATION_JSON)).andReturn();
                    return result.getResponse();

                default:
                    fail("invalid response status");
            }
        }
    }

    // -- tracking methods --

    public void addDataset(String id) {
        createdDatasetIds.add(id);
    }

    public void addSnapshot(String id) {
        createdSnapshotIds.add(id);
    }

    public void addProfile(String id) {
        createdProfileIds.add(id);
    }

    public void addFile(String datasetId, String fileId) {
        String[] createdFile = new String[]{datasetId, fileId};
        createdFileIds.add(createdFile);
    }

    public void removeFile(String datasetId, String fileId) {
        String[] fileToRemove = null;
        for (String[] fileInfo : createdFileIds) {
            if (datasetId.equals(fileInfo[0]) && fileId.equals(fileInfo[1])) {
                fileToRemove = fileInfo;
                break;
            }
        }
        if (fileToRemove != null) {
            createdFileIds.remove(fileToRemove);
        }
    }

    public void addBucket(String bucketName) {
        createdBuckets.add(bucketName);
    }

    // Scratch files are expected to be located in testConfig.getIngestBucket();
    public void addScratchFile(String path) {
        createdScratchFiles.add(path);
    }

    public void setDeleteOnTeardown(boolean deleteOnTeardown) {
        this.deleteOnTeardown = deleteOnTeardown;
    }

    public void teardown() throws Exception {
        if (deleteOnTeardown) {
            // Order is important: delete all the snapshots first so we eliminate dependencies
            // Then delete the files before the datasets
            for (String snapshotId : createdSnapshotIds) {
                deleteTestSnapshot(snapshotId);
            }

            for (String[] fileInfo : createdFileIds) {
                deleteTestFile(fileInfo[0], fileInfo[1]);
            }

            for (String datasetId : createdDatasetIds) {
                deleteTestDataset(datasetId);
            }

            for (String profileId : createdProfileIds) {
                deleteTestProfile(profileId);
            }

            for (String bucketName : createdBuckets) {
                deleteTestBucket(bucketName);
            }

            for (String path : createdScratchFiles) {
                deleteTestScratchFile(path);
            }
        }

        createdSnapshotIds = new ArrayList<>();
        createdFileIds = new ArrayList<>();
        createdDatasetIds = new ArrayList<>();
        createdProfileIds = new ArrayList<>();
        createdBuckets = new ArrayList<>();
        createdScratchFiles = new ArrayList<>();
    }
}
