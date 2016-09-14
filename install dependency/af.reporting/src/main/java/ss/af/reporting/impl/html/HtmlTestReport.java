package ss.af.reporting.impl.html;

import ss.af.reporting.HtmlReportSettings;
import ss.af.reporting.XmlReportSettings;
import ss.af.reporting.impl.xml.XmlReportWriterImpl;
import ss.af.reporting.impl.xml.XmlTestReport;

import java.io.File;
import java.nio.charset.Charset;

/**
 * Html specific implementation of the TestReport
 */
public class HtmlTestReport extends HtmlReportBase {

    /**
     * Initializes a new instance of the HtmlTestReport class.
     *
     * @param settings - The report settings.
     */
    public HtmlTestReport(HtmlReportSettings settings) {
        XmlReportSettings xmlReportSettings = new XmlReportSettings();
        xmlReportSettings.setAppendToExistingReport(false);
        xmlReportSettings.setReportEncoding(Charset.forName("UTF-8"));
        xmlReportSettings.setReportFolder(settings.getReportFolder());
        xmlReportSettings.setReportName(settings.getReportName());
        xmlReportSettings.setReportDescription(settings.getReportDescription());

        XmlTestReport testReport = new XmlTestReport(xmlReportSettings, new XmlReportWriterImpl());
        String testXSLTpath = String.format(".%1$saf.reporting%1$sstyle_sheets%1$sDefault.xslt", File.separator);
        initialize(settings, testReport, testXSLTpath );
    }
    //	<C#>
    /// <summary>
    ///   Finalizes an instance of the <see cref="HtmlTestReport" /> class.  Closes report for current functional test flow
    /// </summary>
    //      ~HtmlTestReport()
    //      {
    //          this.Dispose();
    //      }
    //
    //      #endregion
    //
    //      #region IDisposable

    /// <summary>
    ///   Clean up LocalAutomationReport
    /// </summary>
    //      public void Dispose()
    //      {
    //          if (!this.ReportStarted)
    //          {
    //              return;
    //          }
    //
    //          this.closeReport(new Dictionary<string, string> { { "Warning message", "Report is NOT stopped!" } });
    //          GC.SuppressFinalize(this);
    //      }
    //
    //      #endregion
    //	</C#>
}
