package ss.af.reporting.factories;

import ss.af.reporting.*;
import ss.af.reporting.impl.html.HtmlSuiteReport;
import ss.af.reporting.impl.html.HtmlTestReport;

/**
 * Html specific implementation of the TestReportFactory.
 */
public class HtmlTestReportFactory implements TestReportFactory {
    private HtmlReportSettings settings;

    /**
     * Initializes a new instance of the HtmlTestReportFactory
     *
     * @param settings - The settings.
     */
    public HtmlTestReportFactory(HtmlReportSettings settings) {
        this.settings = settings;
    }

    @Override
    public TestReport getTestReport(String testName) {
        return new HtmlTestReport(createTestReportSpecificSettings(testName));
    }

    @Override
    public SuiteReport getSuiteReport(String projectName, String suiteName) {
        return new HtmlSuiteReport(createSuiteReportSpecificSettings(projectName, suiteName));
    }

    private HtmlReportSettings createTestReportSpecificSettings(String testName) {
        HtmlReportSettings stngs = new HtmlReportSettings();
        stngs.setReportName(testName);
        stngs.setReportDescription(settings.getReportDescription());
        stngs.setReportFolder(settings.getReportFolder());
        stngs.setXslFilePath(settings.getXslFilePath());
        return stngs;
    }

    private HtmlSuiteReportSettings createSuiteReportSpecificSettings(String projectName, String suiteName) {
        HtmlSuiteReportSettings stngs = new HtmlSuiteReportSettings();
        stngs.setProjectName(projectName);
        stngs.setSuiteName(suiteName);
        stngs.setReportName(suiteName);
        stngs.setReportDescription(settings.getReportDescription());
        stngs.setReportFolder(settings.getReportFolder());
        stngs.setXslFilePath(settings.getXslFilePath());
        return stngs;
    }

}
