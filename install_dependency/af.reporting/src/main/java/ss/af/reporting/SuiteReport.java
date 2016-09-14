package ss.af.reporting;

public interface SuiteReport extends TestReport {
    /**
     * Adds the link to the specific test report.
     *
     * @param testReportId - The test report's unique identifier.
     */
    void addLinkToTestReport(TestInformation testReportId);
}
