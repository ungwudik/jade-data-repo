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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"google", "connectedtest"})
@Category(Connected.class)
public class FileLoadProfileTest {
    private static Logger logger = LoggerFactory.getLogger(FileLoadProfileTest.class);

    @Autowired private MockMvc mvc;
    @Autowired private GoogleResourceConfiguration googleResourceConfiguration;
    @Autowired private ConnectedOperations connectedOperations;
    @Autowired private ConfigurationService configService;

    @MockBean private IamService samService;

    private String coreBillingAccountId;
    private BillingProfileModel profileModel;
    private DatasetSummaryModel datasetSummary;

    private Map<Double, String> sizesToFiles;

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

        // build map of source file paths to number of bytes in each, for calculating the bytes/sec
        sizesToFiles = new HashMap<>();
        sizesToFiles.put(Math.pow(10, 2), sourceFile100B);
        sizesToFiles.put(Math.pow(10, 3), sourceFile1KB);
//        sizesToFiles.put(Math.pow(10, 4), sourceFile10KB);
//        sizesToFiles.put(Math.pow(10, 5), sourceFile100KB);
//        sizesToFiles.put(Math.pow(10, 6), sourceFile1MB);
//        sizesToFiles.put(Math.pow(10, 7), sourceFile10MB);
//        sizesToFiles.put(Math.pow(10, 8), sourceFile100MB);
//        sizesToFiles.put(Math.pow(10, 9), sourceFile1GB);
//        sizesToFiles.put(Math.pow(10, 10), sourceFile10GB);
    }

    @After
    public void teardown() throws Exception {
        connectedOperations.teardown();
    }

    private static String sourceBucketName = "jade-testdata";
    private static String sourceFolderName = "fileloadprofiletest";

    private static String sourceFile100B = "100Bfile.txt";
    private static String sourceFile1KB = "1KBfile.txt";
    private static String sourceFile10KB = "10KBfile.txt";
    private static String sourceFile100KB = "100KBfile.txt";
    private static String sourceFile1MB = "1MBfile.txt";
    private static String sourceFile10MB = "10MBfile.txt";
    private static String sourceFile100MB = "100MBfile.txt";
    private static String sourceFile1GB = "1GBfile.txt";
    private static String sourceFile10GB = "10GBfile.txt";

    private static int numRuns = 1;

    @Test
    public void profileFileCopyJavaClientTest() throws Exception {
        String label = "javaClient";
        setFileCopyConfig(true, label);
        Map<Double, List<Long>> sizesToMilliseconds = profileFileCopy();
        printSizesToMillisecondsMapAsCSV(sizesToMilliseconds, label);
    }

    @Test
    public void profileFileCopyGsutilTest() throws Exception {
        String label = "gsutil";
        setFileCopyConfig(false, label);
        Map<Double, List<Long>> sizesToMilliseconds = profileFileCopy();
        printSizesToMillisecondsMapAsCSV(sizesToMilliseconds, label);
    }

    private void printSizesToMillisecondsMapAsCSV(Map<Double, List<Long>> sizesToMilliseconds, String label) {
        System.out.println("label, sourceFileName, size, elapsedTime;");
        for (Map.Entry<Double, List<Long>> sizeToMilliseconds : sizesToMilliseconds.entrySet()) {
            Double size = sizeToMilliseconds.getKey();
            List<Long> elapsedTimes = sizeToMilliseconds.getValue();
            String sourceFileName = sizesToFiles.get(size);

            for (int ctr = 0; ctr < elapsedTimes.size(); ctr++) {
                System.out.println(label + "," + sourceFileName + "," + size + "," + elapsedTimes.get(ctr));
            }
        }
    }

    private void setFileCopyConfig(boolean fileCopyConfigValue, String configLabel) {
        ConfigModel fileCopyConfig = configService.getConfig(ConfigEnum.FILE_COPY_USE_JAVA_CLIENT.name());
        fileCopyConfig.setParameter(new ConfigParameterModel().value(String.valueOf(fileCopyConfigValue)));
        ConfigGroupModel configGroupModel = new ConfigGroupModel()
            .label("FileLoadProfileTest:" + configLabel)
            .addGroupItem(fileCopyConfig);
        configService.setConfig(configGroupModel);
    }

    private Map<Double, List<Long>> profileFileCopy() throws Exception {
        Map<Double, List<Long>> sizesToMilliseconds = new HashMap<>();

        // run the file copies and time them
        for (Map.Entry<Double, String> sizeToFile : sizesToFiles.entrySet()) {
            Double size = sizeToFile.getKey();
            String sourceFileName = sizeToFile.getValue();
            sizesToMilliseconds.put(size, new ArrayList<>());

            for (int ctr = 0; ctr < numRuns; ctr++) {
                long startTime = System.currentTimeMillis();
                loadFile(sourceFileName);
                long elapsedTime = System.currentTimeMillis() - startTime;

                logger.info("size = " + size + ", sourceFileName = " + sourceFileName
                    + ", elapsedTime = " + elapsedTime);
                sizesToMilliseconds.get(size).add(elapsedTime);
            }
        }

        return sizesToMilliseconds;
    }

    private void loadFile(String sourceFileName) throws Exception {
        URI sourceUri = new URI("gs",
            sourceBucketName,
            "/" + sourceFolderName + "/" + sourceFileName,
            null,
            null);
        String targetPath = "/" + sourceFileName;

        FileLoadModel fileLoadModel = new FileLoadModel()
            .sourcePath(sourceUri.toString())
            .description("gsutil")
            .mimeType("text/plain")
            .targetPath(targetPath)
            .profileId(profileModel.getId());

        FileModel fileModel = connectedOperations.ingestFileSuccess(datasetSummary.getId(), fileLoadModel);
        assertThat("file path matches", fileModel.getPath(), equalTo(fileLoadModel.getTargetPath()));

        connectedOperations.deleteTestFile(datasetSummary.getId(), fileModel.getFileId());
    }
}
