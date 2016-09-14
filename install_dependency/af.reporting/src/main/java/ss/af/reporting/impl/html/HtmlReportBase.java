package ss.af.reporting.impl.html;

import ss.af.reporting.HtmlReportSettings;
import ss.af.reporting.ReportListenerLevel;
import ss.af.reporting.TestReport;
import ss.af.reporting.impl.xml.XmlTestReportBase;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

public abstract class HtmlReportBase implements TestReport {

    protected boolean reportStarted;
    private String defaultStyleSheet;
    private XmlTestReportBase report;
    private HtmlReportSettings settings;

    /**
     * Set up the base html report
     *
     * @param level                - Report information level
     * @param testStartRunMetadata - Key-value pairs to add to report
     */
    public void setup(ReportListenerLevel level, Map<String, String> testStartRunMetadata) {
        if (reportStarted) {
            throw new IllegalStateException("Report is already started!");
        }
        reportStarted = true;
        report.setup(level, testStartRunMetadata);
    }

    public void setup(ReportListenerLevel level) {
        setup(level, null);
    }

    public void closeReport(Map<String, String> testEndRunMetadata) {
        if (reportStarted) {     
            String xmlReportPath = new File(settings.getReportFolder(), settings.getReportName() + ".xml").getPath();
            String htmlReportDir = settings.getReportFolder() == null ? "" : settings.getReportFolder();
            String htmlReportName = settings.getReportName()+".html";
            String htmlReportPath = new File(htmlReportDir, htmlReportName).getPath();

            String xslFilePath = settings.getXslFilePath();
            if (xslFilePath == null || xslFilePath.isEmpty()) {
                xslFilePath = getDefaultStyleSheet(htmlReportDir, htmlReportName);
            }
            report.closeReport(testEndRunMetadata);
            // Convert Xml report to Html
            transformXmlToHtml(xmlReportPath, xslFilePath, htmlReportPath);
            copyReportResources(htmlReportDir);
            reportStarted = false;
        }
    }

    public void closeReport() {
        closeReport(null);
    }

    public void logVerbose(String message, Object... args) {
        report.logVerbose(message, args);
    }

    public void logInfo(String message, Object... args) {
        report.logInfo(message, args);
    }

    public void logWarning(String message, Object... args) {
        report.logWarning(message, args);
    }

    public void logError(String message, Object... args) {
        report.logError(message, args);
    }

    public void logImage(BufferedImage image) {
        report.logImage(image);
    }

    public void writeValidationResult(boolean result, String message, Object... args) {
        report.writeValidationResult(result, message, args);
    }

    public void writeTestResult(boolean result, String message, Object... args) {
        report.writeTestResult(result, message, args);
    }

    public void writeExecutionInfo(String infoName, Map<String, String> attributes) {
        report.writeExecutionInfo(infoName, attributes);
    }

    /**
     * The initialize report.
     *
     * @param settings          - The settings.
     * @param xmlTestReport     - The xml test report.
     * @param defaultStyleSheet - The default Style Sheet.
     */
    protected void initialize(HtmlReportSettings settings, XmlTestReportBase xmlTestReport, String defaultStyleSheet) {
        this.defaultStyleSheet = defaultStyleSheet;
        this.settings = settings;
        report = xmlTestReport;
    }

    /**
     * The get default style sheet.
     *
     * @param reportFolder - The report folder.
     * @param reportName   - The report name.
     * @return DefaultStyleSheet
     */
    private String getDefaultStyleSheet(String reportFolder, String reportName) {
        try {
            List<String> defaultSheetLines = Files.readAllLines(Paths.get(defaultStyleSheet), Charset.defaultCharset());
            StringBuilder defaultSheetBuilder = new StringBuilder();
            for (String line : defaultSheetLines) {
                defaultSheetBuilder.append(line + System.lineSeparator());
            }
            String defaultSheet = defaultSheetBuilder.toString();/*.replace("<report-title-template/>", settings.getReportName())*/ //Useless replace?
            String xslPath = new File(reportFolder, reportName + ".xslt").getPath();
            report.setReportStylesheet(defaultSheet, xslPath);
            return xslPath;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Transform XML into HTML using XSLT
     *
     * @param xmlFilePath  - The path to the XML file.
     * @param xslFilePath  - The path to the XSL file.
     * @param htmlFilePath - The path to the HTML file.
     */
    private void transformXmlToHtml(String xmlFilePath, String xslFilePath, String htmlFilePath) {
        //		<C#>
        //		// Loads the xml from path to transform
        //		XmlDocument xmlDoc = new XmlDocument();
        //		xmlDoc.Load(xmlFilePath);
        //
        //		// Loads the xsl from path to transform
        //		XslCompiledTransform xslTrans = new XslCompiledTransform();
        //		xslTrans.Load(xslFilePath);
        //
        //		// Transforms xml to HTML
        //		StringWriter swHtml = new StringWriter();
        //		xslTrans.Transform(xmlDoc.CreateNavigator(), null, swHtml);
        //
        //		// Save html content to file
        //		File.WriteAllText(htmlFilePath, swHtml.ToString());
        //		</C#>
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File(xslFilePath));
            Transformer transformer;
            transformer = factory.newTransformer(xslt);
            Source text = new StreamSource(new File(xmlFilePath));
            transformer.transform(text, new StreamResult(new File(htmlFilePath)));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void copyReportResources(String reportFolderPath) {
        try {
        	String abilitonLogoPath = String.format(".%1$saf.reporting%1$sImages%1$sabiliton_logo.png", File.separator);
        	String servLogoPath = String.format(".%1$saf.reporting%1$sImages%1$sss_logo.png", File.separator);
            Files.copy(Paths.get(abilitonLogoPath), Paths.get(new File(reportFolderPath, "abiliton_logo.png").getPath()), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Paths.get(servLogoPath), Paths.get(new File(reportFolderPath, "ss_logo.png").getPath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
