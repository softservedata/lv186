package ss.af.reporting.impl.xml;

import ss.af.reporting.TestInformation;

public class XmlTestInformation extends TestInformation {
    private boolean testResult;
    private long duration;
    private String reportPath;

    public boolean getTestResult() {
        return testResult;
    }

    public void setTestResult(boolean testResult) {
        this.testResult = testResult;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }
}
