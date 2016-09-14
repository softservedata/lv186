package ss.af.reporting.impl.xml;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.ProcessingInstruction;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;

import ss.af.reporting.utils.Utils;

public class XmlReportWriterImpl implements XmlReportWriter {

	private static final String XML_MESSAGE_NODE_NAME = "message";
	private static final String XML_ROOT_NODE_NAME = "report";
	private static final String IMG_DIRECTORY_NAME = "img";
	private static final String MESSAGE_TIME_FORMAT_PATTERN = "dd MMM, HH:mm:ss.SSS";
	private static final String IMAGE_TIME_FORMAT_PATTERN = "yyyy/MM/dd HH:mm:ss.SSS";

	private File report;
	private File reportFolder;
	protected XMLEventWriter eventWriter;
	private ProcessingInstruction stylesheetElement;
	private boolean isClosed;

	/**
	 * Initialize report writer.
	 *
	 * @param filePath     - The file path.
	 * @param fileEncoding - The file encoding.
	 * @param appendMode   - The append mode.
	 */
	@Override
	public void initialize(String filePath, Charset fileEncoding, boolean appendMode) {
		report = new File(filePath);

		if (appendMode) {
			throw new UnsupportedOperationException("XmlReportWriter appendMode is not implemented"); //TODO ?
		}

		// Create report directory
		reportFolder = report.getParent() == null ? new File("") : new File(report.getParent());
		if (!reportFolder.exists()) {
			reportFolder.mkdirs();
		}

		try {
			// create an XMLOutputFactory
			XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
			//create a file writer
			FileOutputStream fileSteam = new FileOutputStream(report);
			//            OutputStreamWriter outSteam = new OutputStreamWriter(fileSteam, fileEncoding);
			// create XMLEventWriter
			eventWriter = outputFactory.createXMLEventWriter(fileSteam,fileEncoding.toString());
			isClosed = false;
			XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			// create and write Start Tag
			StartDocument startDocument = eventFactory.createStartDocument(fileEncoding.toString());
			StartElement rootNodeElement = eventFactory.createStartElement("", "", XML_ROOT_NODE_NAME);
			eventWriter.add(startDocument);
			eventWriter.add(rootNodeElement);
			//            eventWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (XMLStreamException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Initialize report writer with appendMode = false.
	 *
	 * @param filePath     - The file path.
	 * @param fileEncoding - The file encoding.
	 */
	@Override
	public void initialize(String filePath, Charset fileEncoding) {
		initialize(filePath, fileEncoding, false);
	}

	/**
	 * Write message.
	 *
	 * @param level   - The message level.
	 * @param message - The message value.
	 */
	@Override
	public void writeMessage(String level, String message) {
		checkIfClosed();
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		StartElement messageNodeElementStart = eventFactory.createStartElement("", "", XML_MESSAGE_NODE_NAME);
		EndElement messageNodeElementEnd = eventFactory.createEndElement("", "", XML_MESSAGE_NODE_NAME);

		// Get now time and date.
		String dateTime = Utils.formatTime(MESSAGE_TIME_FORMAT_PATTERN);

		// Create xml attributes for entry
		Attribute timeAttr = eventFactory.createAttribute("time", dateTime);
		Attribute levelAttr = eventFactory.createAttribute("level", level);
		Attribute messageAttr = eventFactory.createAttribute("message", message);
		//		Attribute codefileAttr = eventFactory.createAttribute("codefile", codefile); // TODO Figure out what is that

		// Create CDATA message
		Characters characters = eventFactory.createCharacters(message);

		// Create br node
		StartElement brTagStart = eventFactory.createStartElement("", "", "br");
		EndElement brTagEnd = eventFactory.createEndElement("", "", "br");

		try {
			//start
			eventWriter.add(messageNodeElementStart);
			//attributes
			eventWriter.add(timeAttr);
			eventWriter.add(levelAttr);
			eventWriter.add(messageAttr);
			//Characters
			eventWriter.add(characters);
			eventWriter.add(brTagStart);
			eventWriter.add(brTagEnd);
			//end
			eventWriter.add(messageNodeElementEnd);
		} catch (XMLStreamException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Create node and write attributes.
	 *
	 * @param nodeName         - The node name.
	 * @param attributesValues - The attributes values.
	 */
	@Override
	public void writeNodeAttributes(String nodeName, Map<String, String> attributesValues) {
		checkIfClosed();
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		StartElement nodeElementStart = eventFactory.createStartElement("", "", nodeName);
		EndElement nodeElementEnd = eventFactory.createEndElement("", "", nodeName);

		try {
			eventWriter.add(nodeElementStart);
			for (String key : attributesValues.keySet()) {
				Attribute attribute = eventFactory.createAttribute(key, attributesValues.get(key));
				eventWriter.add(attribute);
			}
			eventWriter.add(nodeElementEnd);
		} catch (XMLStreamException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Create node and write attributes.
	 *
	 * @param nodeName        - The node name.
	 * @param childNodeValues - The attributes values.
	 */
	@Override
	public void writeChildNode(String nodeName, Map<String, Map<String, String>> childNodeValues) {
		// NO USAGES FOUND
		throw new UnsupportedOperationException("XmlReportWriter writeChildNode(String,Map) is not implemented"); //TODO ?
	}

	/**
	 * Add image to report.
	 *
	 * @param level - The report message level.
	 * @param img   - The image.
	 */
	@Override
	public void addImage(String level, BufferedImage img) {
		// Create thumb image
		BufferedImage trumbImg = Utils.getThumbnailImage(img, 10);

		// Set screenshot names and paths
		String screenshotName = report.getName() + ".png";
		String screenshotThumbName = report.getName() + "_thumb.png";
		File imgDirectory = new File(reportFolder, IMG_DIRECTORY_NAME);
		File imgFile = new File(imgDirectory, screenshotName);
		File imgThumbFile = new File(imgDirectory, screenshotThumbName);

		if (!imgDirectory.exists()) {
			imgDirectory.mkdirs();
		}

		// Save screenshots
		try {
			ImageIO.write(img, "png", imgFile);
			ImageIO.write(trumbImg, "png", imgThumbFile);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		// Add image to report
		writeImageEntry(imgFile, imgThumbFile, level);
	}

	/**
	 * Sets the name of the file to load the XSL content from. Can be used to generate report file with custom formatting.
	 *
	 * @param xslFilePath - The path to the XSL file
	 */
	@Override
	public void setReportStylesheetFile(String xslFilePath) {
		if (xslFilePath == null || xslFilePath.isEmpty()) {
			return;
		}

		File xslFile = new File(xslFilePath);
		String xslFileName = xslFile.getName();
		String data = String.format("type='text/xsl' href='%s'", xslFileName);
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		stylesheetElement = eventFactory.createProcessingInstruction("xml-stylesheet", data);
	}

	public void close() {
		try {
			XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			eventWriter.add(eventFactory.createEndDocument());
			if (stylesheetElement != null) {
				eventWriter.add(stylesheetElement);
			}
			eventWriter.close();
			isClosed = true;
		} catch (XMLStreamException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	private void writeImageEntry(File img, File trumbImg, String level) {
		checkIfClosed();
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		StartElement imageNodeElementStart = eventFactory.createStartElement("", "", XML_MESSAGE_NODE_NAME);
		EndElement imageNodeElementEnd = eventFactory.createEndElement("", "", XML_MESSAGE_NODE_NAME);

		Path thumbPath = trumbImg.toPath();
		Path imgPath = img.toPath();
		Path reportFolderPath = reportFolder.toPath();

		// Gets now time.
		String dateTime = Utils.formatTime(IMAGE_TIME_FORMAT_PATTERN);

		// Create <a> entry
		StartElement aNodeStart = eventFactory.createStartElement("", "", "a");
		EndElement aNodeEnd = eventFactory.createEndElement("", "", "a");
		String href = reportFolderPath.relativize(imgPath).toString();
		Attribute hrefScreeAttr = eventFactory.createAttribute("href", href);

		// Create xml attributes for entry
		Attribute timeAttr = eventFactory.createAttribute("time", dateTime);
		Attribute levelAttr = eventFactory.createAttribute("level", level);

		// Create <img> entry
		StartElement imgNodeStart = eventFactory.createStartElement("", "", "img");
		EndElement imgNodeEnd = eventFactory.createEndElement("", "", "img");
		String src = reportFolderPath.relativize(thumbPath).toString();
		Attribute srcScreenAttr = eventFactory.createAttribute("src",src);

		try {
			//start
			eventWriter.add(imageNodeElementStart);
			//attributes
			eventWriter.add(timeAttr);
			eventWriter.add(levelAttr);
			// <a> entry
			eventWriter.add(aNodeStart);
			eventWriter.add(hrefScreeAttr);
			// <img> entry
			eventWriter.add(imgNodeStart);
			eventWriter.add(srcScreenAttr);
			eventWriter.add(imgNodeEnd);
			// </a> entry
			eventWriter.add(aNodeEnd);
			//end
			eventWriter.add(imageNodeElementEnd);
		} catch (XMLStreamException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private void checkIfClosed(){
		if(isClosed){
			throw new IllegalStateException("Report '"+report.getName()+"' was closed, and is no longer available for adding data.");
		}
	}
}
