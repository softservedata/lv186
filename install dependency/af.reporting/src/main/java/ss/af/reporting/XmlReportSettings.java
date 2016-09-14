package ss.af.reporting;

import java.nio.charset.Charset;

public class XmlReportSettings {
    private String reportName;
    private String reportFolder;
    private String reportDescription;
    private Charset reportEncoding;
    private boolean appendToExistingReport;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportFolder() {
        return reportFolder;
    }

    public void setReportFolder(String reportFolder) {
        this.reportFolder = reportFolder;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public Charset getReportEncoding() {
        return reportEncoding;
    }

    public void setReportEncoding(Charset reportEncoding) {
        this.reportEncoding = reportEncoding;
    }

    public boolean isAppendToExistingReport() {
        return appendToExistingReport;
    }

    public void setAppendToExistingReport(boolean appendToExistingReport) {
        this.appendToExistingReport = appendToExistingReport;
    }
}
