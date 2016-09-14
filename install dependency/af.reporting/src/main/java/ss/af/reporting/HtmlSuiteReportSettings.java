package ss.af.reporting;

public class HtmlSuiteReportSettings {
    private String reportName;
    private String reportFolder;
    private String reportDescription;
    private String suiteName;
    private String projectName;
    private int testsCount;
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

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getTestsCount() {
        return testsCount;
    }

    public void setTestsCount(int testsCount) {
        this.testsCount = testsCount;
    }

    public String getXslFilePath() {
        return xslFilePath;
    }

    public void setXslFilePath(String xslFilePath) {
        this.xslFilePath = xslFilePath;
    }
}
