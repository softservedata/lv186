package ss.af.reporting;

/**
 * Defines methods to get of TestReport and SuiteReport.
 */
public interface TestReportFactory {
    /**
     * Gets the implementation of TestReport.
     *
     * @param testName - Name of the test to report
     * @return Instance of theTestReport
     */
    TestReport getTestReport(String testName);

    /**
     * Gets the implementation of ISuiteReport.
     *
     * @param projectName - Name of the project
     * @param suiteName   - Name of the test suite
     * @return Instance of the SuiteReport
     */
    SuiteReport getSuiteReport(String projectName, String suiteName);
}
