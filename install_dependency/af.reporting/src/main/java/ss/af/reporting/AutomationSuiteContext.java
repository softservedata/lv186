package ss.af.reporting;

import ss.af.reporting.baseclasses.AutoTestWithReporting;
import ss.af.reporting.statistics.StatisticsCollector;

public class AutomationSuiteContext {
    private static AutomationSuiteContext automationSuiteContext;

    private final StatisticsCollector statisticsCollector;

    private boolean isInitialized;
    private SuiteReport suiteReport;
    private String suiteName;
    private String projectName;
    private int testsPlannedToAutomate;
    private int passedTests;
    private int failedTests;
    private long suiteStartTime;
    private AutoTestWithReporting currentExecutedTest;

    /**
     * Prevents a default instance of the "AutomationSuiteContext" class from being created.
     */
    private AutomationSuiteContext() {
        suiteStartTime = System.currentTimeMillis();
        statisticsCollector = new StatisticsCollector();
    }

    /**
     * Gets the instance of this class.
     *
     * @return Instance of AutomationSuiteContext
     */
    public static AutomationSuiteContext getInstance() {
        automationSuiteContext = automationSuiteContext == null ? new AutomationSuiteContext() : automationSuiteContext;
        return automationSuiteContext;
    }

    /**
     * Gets the currently executed test.
     *
     * @return currentExecutedTest
     */
    public AutoTestWithReporting getCurrentExecutedTest() {
        return currentExecutedTest;
    }

    /**
     * Sets the currently executed test.
     *
     * @param automationTest
     */
    public void setCurrentExecutedTest(AutoTestWithReporting automationTest) {
        currentExecutedTest = automationTest;
    }

    /**
     * Gets the statistics collector.
     *
     * @return Statistics Collector
     */
    public StatisticsCollector getStatisticsCollector() {
        checkInitialized();
        return statisticsCollector;
    }

    /**
     * Gets the name of the project.
     *
     * @return Project Name
     */
    public String getProjectName() {
        checkInitialized();
        return projectName;
    }

    /**
     * Gets the name of the suite.
     *
     * @return Suite Name
     */
    public String getSuiteName() {
        checkInitialized();
        return suiteName;
    }

    /**
     * Gets the tests planned to automate.
     *
     * @return Tests Planned To Automate
     */
    public int getTestsPlannedToAutomate() {
        checkInitialized();
        return testsPlannedToAutomate;
    }

    /**
     * Gets the passed tests.
     *
     * @return Passed Tests
     */
    public int getPassedTests() {
        return passedTests;
    }

    /**
     * Sets the passed tests.
     *
     */
    public void setPassedTests(int passedTests) {
        this.passedTests = passedTests;
    }

    /**
     * Increments the passed tests.
     */
    public void incrementPassedTests() {
        passedTests++;
    }

    /**
     * Gets the failed tests.
     *
     * @return Failed Tests
     */
    public int getFailedTests() {
        return failedTests;
    }

    /**
     * Sets the failed tests.
     *
     * @param failedTests to set
     */
    public void setFailedTests(int failedTests) {
        this.failedTests = failedTests;
    }

    /**
     * Increments the failed tests.
     */
    public void incrementFailedTests() {
        failedTests++;
    }

    /**
     * Gets the suite start time.
     *
     * @return Suite Start Time in millis
     */
    public long getSuiteStartTime() {
        return suiteStartTime;
    }

//	private void setSuiteStartTime(long startTime) {
//		this.suiteStartTime = startTime;
//	}

    /**
     * Gets the suite report.
     *
     * @return SuiteReport
     */
    public SuiteReport getSuiteReport() {
        checkInitialized();
        if (suiteReport == null) {
            throw new IllegalStateException("SuiteReport is not initialized.");
        }
        return suiteReport;
    }

    /**
     * Sets the suite report.
     *
     * @param value SuiteReport to set
     */
    public void setSuiteReport(SuiteReport value) {
        suiteReport = value;
    }

    /**
     * Initializes the specified project name.
     *
     * @param projectName            - Name of the project.
     * @param suiteName              - The tests planned to automate.
     * @param testsPlannedToAutomate - The AutomationSuiteContext is already initialized
     */
    public void initialize(String projectName, String suiteName, int testsPlannedToAutomate) {
        if (isInitialized) {
            throw new IllegalStateException("The AutomationSuiteContext is already initialized.");
        }

        this.projectName = projectName;
        this.suiteName = suiteName;
        this.testsPlannedToAutomate = testsPlannedToAutomate;

        isInitialized = true;
    }

    /**
     * Performs default report setup.
     */
    public void defaultReportSetup() {
        suiteReport = GenericReportsFactory.createHtmlReport(new HtmlReportSettings()).getSuiteReport(projectName, suiteName);
    }

    private void checkInitialized() {
        if (!isInitialized) {
            throw new IllegalStateException("SuiteReport is not initialized.");
        }
    }

}
