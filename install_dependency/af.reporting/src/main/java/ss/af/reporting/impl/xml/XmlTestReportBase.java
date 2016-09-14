package ss.af.reporting.impl.xml;

import ss.af.reporting.ReportListenerLevel;
import ss.af.reporting.TestReport;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class XmlTestReportBase implements TestReport {

    private static final String XML_START_REPORT_METADATA_NODE_NAME = "start-report-metadata";
    private static final String XML_END_REPORT_METADATA_NODE_NAME = "end-report-metadata";

    protected XmlReportWriter reportWriter;
    protected boolean isRunning = false;
    protected ReportListenerLevel reportLevel;

    /**
     * Initializes a new instance of the XmlTestReportBase class.
     *
     * @param xmlReportWriter - The IXmlReportWriter implementation.
     */
    public XmlTestReportBase(XmlReportWriter xmlReportWriter) {
        reportWriter = xmlReportWriter;
    }

    /**
     * Set up the report
     *
     * @param level                - Report information level
     * @param testStartRunMetadata - Key-value pairs to add to report
     */
    public void setup(ReportListenerLevel level, Map<String, String> testStartRunMetadata) {
        if (isRunning) {
            throw new IllegalStateException("Report is already started!");
        }

        isRunning = true;

        reportLevel = level;
    }

    /**
     * Set up the report with testStartRunMetadata = null
     *
     * @param level - Report information level
     */
    public void setup(ReportListenerLevel level) {
        setup(level, null);
    }

    @Override
    public void closeReport(Map<String, String> testEndRunMetadata) {
        reportWriter.close();
        isRunning = false;
    }

    @Override
    public void closeReport() {
        closeReport(null);
    }

    /**
     * Logs the message as verbose data.
     *
     * @param message - The message.
     * @param args  - The arguments.
     */
    public void logVerbose(String message, Object... args) {
        if (reportLevel == ReportListenerLevel.All) {
            reportWriter.writeMessage("VERBOSE", String.format(message, args));
        }
    }

    /**
     * Logs the message as information.
     *
     * @param message - The message.
     * @param args  - The arguments.
     */
    public void logInfo(String message, Object... args) {
        if (reportLevel == ReportListenerLevel.All ||
                reportLevel == ReportListenerLevel.ExcludeVerbose) {
            reportWriter.writeMessage("INFO", String.format(message, args));
        }
    }

    /**
     * Logs the message as warning.
     *
     * @param message - The message.
     * @param args  - The arguments.
     */
    public void logWarning(String message, Object... args) {
        if (reportLevel == ReportListenerLevel.All ||
                reportLevel == ReportListenerLevel.ExcludeVerbose) {
            reportWriter.writeMessage("WARNING", String.format(message, args));
        }
    }

    /**
     * Logs the message as error.
     *
     * @param message - The message.
     * @param args  - The arguments.
     */
    public void logError(String message, Object... args) {
        if (reportLevel == ReportListenerLevel.All ||
                reportLevel == ReportListenerLevel.ExcludeVerbose) {
            reportWriter.writeMessage("ERROR", String.format(message, args));
        }
    }

    /**
     * Logs the image.
     */
    public void logImage(BufferedImage image) {
        if (reportLevel == ReportListenerLevel.All ||
                reportLevel == ReportListenerLevel.ExcludeVerbose) {
            reportWriter.addImage("INFO", image);
        }
    }

    /**
     * Writes the validation result.
     *
     * @param message - The message.
     * @param args  - The arguments.
     */
    public void writeValidationResult(boolean result, String message, Object... args) {
        if (reportLevel != ReportListenerLevel.OnlyTestResults &&
                ((reportLevel == ReportListenerLevel.OnlyFailedValidations && !result) || reportLevel != ReportListenerLevel.OnlyFailedValidations)) {
            reportWriter.writeMessage(result ? "VALIDATION-SUCCESSFUL" : "VALIDATION-FAILED", String.format(message, args));
        }
    }

    /**
     * Writes the test result.
     *
     * @param result  - if set to true test succeeded, otherwise it is failed.
     * @param message - The message.
     * @param args  - The arguments.
     */
    public void writeTestResult(boolean result, String message, Object... args) {
        if (reportLevel != ReportListenerLevel.OnlyValidations &&
                reportLevel != ReportListenerLevel.OnlyFailedValidations) {
            String resMessage = String.format(message, args);
            reportWriter.writeMessage(result ? "SUCCESS" : "FAILURE", resMessage);
        }
    }

    /**
     * Writes the execution information.
     *
     * @param infoName   - Name of the information.
     * @param attributes - The attributes.
     */
    public void writeExecutionInfo(String infoName, Map<String, String> attributes) {
        reportWriter.writeNodeAttributes(infoName, attributes);
    }

    /**
     * Sets the report XSL file content. Can be used to generate report file with custom formatting.
     *
     * @param xslContent  - Content of the XSL file
     * @param xslFileName - The path to the XSL file
     * @throws IOException
     */
    public void setReportStylesheet(String xslContent, String xslFileName) throws IOException {
        Path xslContentPath = Paths.get(xslFileName);
        Files.write(xslContentPath, xslContent.getBytes());
        reportWriter.setReportStylesheetFile(xslFileName);
    }

    /**
     * The write start test metadata.
     *
     * @param metadata - The metadata.
     */
    protected void writeStartMetadata(Map<String, String> metadata) {
        for (Entry<String, String> pair : metadata.entrySet()) {
            HashMap<String, String> attributesValues = new HashMap<String, String>();
            attributesValues.put("key", pair.getKey());
            attributesValues.put("value", pair.getValue());
            reportWriter.writeNodeAttributes(XML_START_REPORT_METADATA_NODE_NAME, attributesValues);
        }
    }

    /**
     * The write test end metadata.
     *
     * @param metadata - The metadata.
     */
    protected void writeEndMetadata(Map<String, String> metadata) {
        for (Entry<String, String> pair : metadata.entrySet()) {
            HashMap<String, String> attributesValues = new HashMap<String, String>();
            attributesValues.put("key", pair.getKey());
            attributesValues.put("value", pair.getValue());
            reportWriter.writeNodeAttributes(XML_END_REPORT_METADATA_NODE_NAME, attributesValues);
        }
    }
}
