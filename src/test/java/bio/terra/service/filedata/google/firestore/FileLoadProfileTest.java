package bio.terra.service.filedata.google.firestore;

import bio.terra.common.category.Connected;
import bio.terra.common.fixtures.ConnectedOperations;
import bio.terra.model.BillingProfileModel;
import bio.terra.model.ConfigGroupModel;
import bio.terra.model.ConfigModel;
import bio.terra.model.ConfigParameterModel;
import bio.terra.model.DatasetSummaryModel;
import bio.terra.model.FileLoadModel;
import bio.terra.model.FileModel;
import bio.terra.service.configuration.ConfigEnum;
import bio.terra.service.configuration.ConfigurationService;
import bio.terra.service.iam.IamService;
import bio.terra.service.resourcemanagement.google.GoogleResourceConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"google", "connectedtest"})
@Category(Connected.class)
public class FileLoadProfileTest {
    @Autowired private MockMvc mvc;
    @Autowired private GoogleResourceConfiguration googleResourceConfiguration;
    @Autowired private ConnectedOperations connectedOperations;
    @Autowired private ConfigurationService configService;

    @MockBean private IamService samService;

    private String coreBillingAccountId;
    private BillingProfileModel profileModel;
    private DatasetSummaryModel datasetSummary;

    @Before
    public void setup() throws Exception {
        // don't need access checks enabled for these tests
        connectedOperations.stubOutSamCalls(samService);

        // create profile
        coreBillingAccountId = googleResourceConfiguration.getCoreBillingAccount();
        profileModel = connectedOperations.createProfileForAccount(coreBillingAccountId);

        // create dataset
        datasetSummary = connectedOperations.createDataset(profileModel, "snapshot-test-dataset.json");

        // Make sure we start from a known configuration
        configService.reset();
        ConfigModel concurrentConfig = configService.getConfig(ConfigEnum.LOAD_CONCURRENT_FILES.name());
        concurrentConfig.setParameter(new ConfigParameterModel().value("1"));
        ConfigModel driverWaitConfig = configService.getConfig(ConfigEnum.LOAD_DRIVER_WAIT_SECONDS.name());
        driverWaitConfig.setParameter(new ConfigParameterModel().value("30"));
        ConfigGroupModel configGroupModel = new ConfigGroupModel()
            .label("FileOperationTest")
            .addGroupItem(concurrentConfig)
            .addGroupItem(driverWaitConfig);
        configService.setConfig(configGroupModel);
    }

    @After
    public void teardown() throws Exception {
        connectedOperations.teardown();
    }

    @Test
    public void marikoTest() throws Exception {
        URI sourceUri = new URI("gs",
            "broad-jade-mm-ingestdata",
            "/tsvTransferService.tsv",
            null,
            null);
        String targetPath = "/mariko/files/tsvTransferService.tsv";

        FileLoadModel fileLoadModel = new FileLoadModel()
            .sourcePath(sourceUri.toString())
            .description("gsutil")
            .mimeType("text/tab-separated-values")
            .targetPath(targetPath)
            .profileId(profileModel.getId());

        FileModel fileModel = connectedOperations.ingestFileSuccess(datasetSummary.getId(), fileLoadModel);
        assertThat("file path matches", fileModel.getPath(), equalTo(fileLoadModel.getTargetPath()));

        connectedOperations.deleteTestFile(datasetSummary.getId(), fileModel.getFileId());
    }
}
