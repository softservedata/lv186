package ss.af.reporting;

public class HtmlReportSettings {
    private String reportName;
    private String reportFolder;
    private String reportDescription;
    private String xslFilePath;

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

    public String getXslFilePath() {
        return xslFilePath;
    }

    public void setXslFilePath(String xslFilePath) {
        this.xslFilePath = xslFilePath;
    }
}
