package ss.af.reporting.impl.html;

import ss.af.reporting.*;
import ss.af.reporting.impl.xml.XmlReportWriterImpl;
import ss.af.reporting.impl.xml.XmlSuiteReport;

import java.io.File;
import java.nio.charset.Charset;

public class HtmlSuiteReport extends HtmlReportBase implements SuiteReport {

    private final XmlSuiteReport suiteReport;

    /**
     * Initializes a new instance of the HtmlSuiteReport class.
     *
     * @param settings - The settings.
     */
    public HtmlSuiteReport(HtmlSuiteReportSettings settings) {
        XmlSuiteReportSettings xmlSettings = new XmlSuiteReportSettings();
        xmlSettings.setProjectName(settings.getProjectName());
        xmlSettings.setReportDescription(settings.getReportDescription());
        xmlSettings.setReportEncoding(Charset.forName("UTF-8"));
        xmlSettings.setReportFolder(settings.getReportFolder());
        xmlSettings.setReportName(settings.getReportName());
        xmlSettings.setSuiteName(settings.getSuiteName());
        xmlSettings.setTestsCount(settings.getTestsCount());

        HtmlReportSettings htmlSettings = new HtmlReportSettings();
        htmlSettings.setReportFolder(settings.getReportFolder());
        htmlSettings.setReportName(settings.getReportName());
        htmlSettings.setXslFilePath(settings.getXslFilePath());

        suiteReport = new XmlSuiteReport(xmlSettings, new XmlReportWriterImpl());
        String suiteXSLTpath = String.format(".%1$saf.reporting%1$sstyle_sheets%1$sDefaultSuite.xslt", File.separator);
        initialize(htmlSettings, suiteReport, suiteXSLTpath);
    }

    /**
     * Adds the link to the specific test report.
     *
     * @param testReportId - The test report's unique identifier.
     */
    @Override
    public void addLinkToTestReport(TestInformation testReportId) {
        suiteReport.addLinkToTestReport(testReportId);
    }

    //	<C#>
    //	/// <summary>
    //	///   Finalizes an instance of the <see cref="HtmlSuiteReport" /> class.  Closes report for current functional test flow
    //	/// </summary>
    //	~HtmlSuiteReport()
    //	{
    //		this.Dispose();
    //	}
    //
    //	/// <summary>
    //	/// Performs application-defined tasks associated with freeing, releasing, or resetting unmanaged resources.
    //	/// </summary>
    //	public void Dispose()
    //	{
    //		if (!this.ReportStarted)
    //		{
    //			return;
    //		}
    //
    //		this.closeReport(new Dictionary<string, string> { { "Warning message", "Report is NOT stopped!" } });
    //		GC.SuppressFinalize(this);
    //	}
    //	</C#>
}
