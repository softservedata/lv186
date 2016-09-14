package ss.af.reporting.impl.xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import ss.af.reporting.AutomationSuiteContext;
import ss.af.reporting.ReportListenerLevel;
import ss.af.reporting.SuiteReport;
import ss.af.reporting.TestInformation;
import ss.af.reporting.XmlSuiteReportSettings;
import ss.af.reporting.utils.Utils;

public class XmlSuiteReport extends XmlTestReportBase implements SuiteReport {

    private static final String XML_SUITE_INFO_NODE_NAME = "suiteInfo";
    private static final String XML_SUITE_STATISTIC_NODE_NAME = "suiteStatistic";
    private static final String XML_TEST_MESSAGE_NODE_NAME = "testmessage";
    private static final String STR_TEST_PASSED = "PASSED";
    private static final String STR_TEST_FAILED = "FAILED";
    private static final String TEST_DURATION_PATTERN = "HH:mm:ss.SSS";
    private static final String DATE_TIME_PATTERN = "dd MMM yyy HH:mm:ss.SSS aa";

    private final XmlSuiteReportSettings settings;

    /**
     * Initializes a new instance of the XmlSuiteReport class.
     *
     * @param settings     - The settings.
     * @param reportWriter - The report writer.
     */
    public XmlSuiteReport(XmlSuiteReportSettings settings, XmlReportWriter reportWriter) {
        super(reportWriter);
        this.settings = settings;

        this.reportWriter = reportWriter;
        this.reportWriter.initialize(
                new File(settings.getReportFolder(), settings.getReportName() + ".xml").getPath(),
                this.settings.getReportEncoding(),
                false);
    }

    /**
     * Setups the suite report.
     *
     * @param level                - The report listener level.
     * @param testStartRunMetadata - Test run's start metadata.
     */
    public void setup(ReportListenerLevel level, Map<String, String> testStartRunMetadata) {
        if (isRunning) {
            throw new IllegalStateException("Report is already started!");
        }

        reportLevel = level;
        isRunning = true;

        HashMap<String, String> nodeAttributes = new HashMap<String, String>();
        nodeAttributes.put("name", settings.getSuiteName());
        nodeAttributes.put("projectName", settings.getProjectName());
        nodeAttributes.put("description", settings.getReportDescription());
        reportWriter.writeNodeAttributes(XML_SUITE_INFO_NODE_NAME, nodeAttributes);

        if (testStartRunMetadata != null) {
            writeStartMetadata(testStartRunMetadata);
        }
    }

    /**
     * Setups the suite report with testStartRunMetadata = null.
     *
     * @param level - The report listener level.
     */
    public void setup(ReportListenerLevel level) {
        setup(level, null);
    }

    /**
     * Closes the suite report.
     *
     * @param testEndRunMetadata - The test end run metadata.
     */
    public void closeReport(Map<String, String> testEndRunMetadata) {
        if (!isRunning) {
            throw new IllegalStateException("Report is not running.");
        }

        isRunning = false;
        AutomationSuiteContext context = AutomationSuiteContext.getInstance();
        int passedTests = context.getPassedTests();
        int failedTests = context.getFailedTests();
        int runnedTests = passedTests + failedTests;
        String startTime = Utils.formatTime(DATE_TIME_PATTERN, context.getSuiteStartTime());
        String endTime = Utils.formatTime(DATE_TIME_PATTERN);

        HashMap<String, String> attributes = new HashMap<String, String>();
        attributes.put("totalTestsCount", String.valueOf(settings.getTestsCount()));
        attributes.put("runnedTestsCount", String.valueOf(runnedTests));
        attributes.put("passedTestsCount", String.valueOf(passedTests));
        attributes.put("failedTestsCount", String.valueOf(failedTests));
        attributes.put("startTime", startTime);
        attributes.put("endTime", endTime);

        reportWriter.writeNodeAttributes(XML_SUITE_STATISTIC_NODE_NAME, attributes);

        if (testEndRunMetadata != null) {
            writeEndMetadata(testEndRunMetadata);
        }
        super.closeReport(testEndRunMetadata);
    }

    /**
     * Closes the suite report with testEndRunMetadata = null.
     */
    public void closeReport() {
        closeReport(null);
    }

    /**
     * Adds the link to the specific test report.
     *
     * @param testInfo - The test report's unique identifier.
     */
    @Override
    public void addLinkToTestReport(TestInformation testInfo) {
        addLinkToTestReport((XmlTestInformation) testInfo);
    }

    /**
     * Adds the link to the specific test report.
     *
     * @param xmlTestInfo - The test report's unique identifier.
     */
    public void addLinkToTestReport(XmlTestInformation xmlTestInfo) {
        if (!isRunning) {
            throw new IllegalStateException("Report is not running.");
        }

        if (xmlTestInfo != null) {
            String testResult = xmlTestInfo.getTestResult() ? STR_TEST_PASSED : STR_TEST_FAILED;
            String duration = Utils.formatTimeNoTimeZone(TEST_DURATION_PATTERN, xmlTestInfo.getDuration());

            HashMap<String, String> attributes = new HashMap<String, String>();
            attributes.put("testName", xmlTestInfo.getTestIdentifier());
            attributes.put("status", testResult);
            attributes.put("duration", duration);
            attributes.put("reportPath", xmlTestInfo.getReportPath());

            reportWriter.writeNodeAttributes(XML_TEST_MESSAGE_NODE_NAME, attributes);
        }
    }
}
