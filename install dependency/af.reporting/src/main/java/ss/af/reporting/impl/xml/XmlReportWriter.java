package ss.af.reporting.impl.xml;

import java.awt.image.BufferedImage;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * The XmlReportWriter interface.
 */
interface XmlReportWriter {
    /**
     * Initialize report writer.
     *
     * @param filePath     - The file path.
     * @param fileEncoding - The file encoding.
     * @param appendMode   - The append mode.
     */
    void initialize(String filePath, Charset fileEncoding, boolean appendMode);

    /**
     * Initialize report writer.
     * Calls initialize() with appendMode = false.
     *
     * @param filePath     - The file path.
     * @param fileEncoding - The file encoding.
     */
    void initialize(String filePath, Charset fileEncoding);  // boolean appendMode = false

    /**
     * Write message.
     *
     * @param level   - The message level.
     * @param message - The message value.
     */
    void writeMessage(String level, String message);

    /**
     * Create node and write attributes.
     *
     * @param nodeName         - The node name.
     * @param attributesValues - The attributes values.
     */
    void writeNodeAttributes(String nodeName, Map<String, String> attributesValues);

    /**
     * Writes the child node.
     *
     * @param nodeName        - Name of the node.
     * @param childNodeValues - The child node values.
     */
    void writeChildNode(String nodeName, Map<String, Map<String, String>> childNodeValues);

    /**
     * Add image to report.
     *
     * @param level - The report message level.
     * @param img   - The image.
     */
    void addImage(String level, BufferedImage img);

    /**
     * Sets the name of the file to load the XSL content from. Can be used to generate report file with custom formatting.
     *
     * @param xslFilePath - The path to the XSL file
     */
    void setReportStylesheetFile(String xslFilePath);

    /**
     * Closes the writer and frees any resources associated with this
     */
    void close();
}
