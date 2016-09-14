package ss.af.reporting;

import ss.af.reporting.factories.HtmlTestReportFactory;

public class GenericReportsFactory {
    /**
     * Creates instance of the Html specific implementation of the TestReportFactory.
     *
     * @param settings - The Html specific settings.
     * @return Instance of the TestReportFactory
     */
    public static TestReportFactory createHtmlReport(HtmlReportSettings settings) {
        return new HtmlTestReportFactory(settings);
    }
}
