package ss.af.reporting.impl.xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import ss.af.reporting.ReportListenerLevel;
import ss.af.reporting.XmlReportSettings;
import ss.af.reporting.utils.Utils;

public class XmlTestReport extends XmlTestReportBase {

    private static final String XML_REPORT_NAME_NODE_NAME = "report-name";
    private static final String XML_REPORT_DESCRIPTION_NODE_NAME = "report-description";
    private static final String XML_REPORT_START_DATE_TIME_NODE_NAME = "report-start-datetime";
    private static final String DATE_TIME_PATTERN = "dd MMM yyy HH:mm:ss.SSS aa";

    private final XmlReportSettings settings;

    /**
     * Initializes a new instance of the XmlTestReport class.
     *
     * @param settings     - The report settings.
     * @param reportWriter - The IXmlReportWriter implementation.
     */
    public XmlTestReport(XmlReportSettings settings, XmlReportWriter reportWriter) {
        super(reportWriter);
        this.settings = settings;
        this.reportWriter.initialize(
                new File(this.settings.getReportFolder(), this.settings.getReportName() + ".xml").getPath(),
                this.settings.getReportEncoding(),
                this.settings.isAppendToExistingReport());
    }

    /**
     * Set up the report
     *
     * @param level                - Report information level
     * @param testStartRunMetadata - Key-value pairs to add to report
     */
    public void setup(ReportListenerLevel level, Map<String, String> testStartRunMetadata) {
        super.setup(level, testStartRunMetadata);
        if (!settings.isAppendToExistingReport()) {
            HashMap<String, String> nameAttribute = new HashMap<String, String>();
            nameAttribute.put("value", settings.getReportName());
            reportWriter.writeNodeAttributes(XML_REPORT_NAME_NODE_NAME, nameAttribute);

            HashMap<String, String> descriptionAttribute = new HashMap<String, String>();
            descriptionAttribute.put("value", settings.getReportDescription());
            reportWriter.writeNodeAttributes(XML_REPORT_DESCRIPTION_NODE_NAME, descriptionAttribute);

            HashMap<String, String> dateAttribute = new HashMap<String, String>();
            String dateTime = Utils.formatTime(DATE_TIME_PATTERN);
            dateAttribute.put("value", dateTime);
            reportWriter.writeNodeAttributes(XML_REPORT_START_DATE_TIME_NODE_NAME, dateAttribute);
        }
        if (testStartRunMetadata != null) {
            writeStartMetadata(testStartRunMetadata);
        }
    }

    /**
     * Set up the report with testStartRunMetadata = null
     *
     * @param level - Report information level
     */
    public void setup(ReportListenerLevel level) {
        setup(level, null);
    }

    /**
     * Finishes the report
     *
     * @param testEndRunMetadata - Key-value pairs to add to report
     */
    @Override
    public void closeReport(Map<String, String> testEndRunMetadata) {
        if (testEndRunMetadata != null) {
            writeEndMetadata(testEndRunMetadata);
        }
        super.closeReport(testEndRunMetadata);
    }

    @Override
    public void closeReport() {
        closeReport(null);
    }
}
