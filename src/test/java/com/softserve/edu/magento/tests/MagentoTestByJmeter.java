package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.admin.IAdminUser;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Created by Mickle on 8/25/2016.
 */
public class MagentoTestByJmeter {

    private File jmeterProperties;
    private File jmeterHome;
    private String slash;
    private StandardJMeterEngine jmeter;
    private HashTree testPlanTree;
    //Set jmeter home for the jmeter utils to load
    @BeforeClass
    public void setupClass() throws NoSuchFileException {
        jmeterHome = new File("C:\\JMeter");
        slash = System.getProperty("file.separator");
        if (jmeterHome.exists()) {
            jmeterProperties = new File(jmeterHome.getPath() + slash + "bin" + slash + "jmeter.properties");
        }
        if (!jmeterProperties.exists()) {
            throw new NoSuchFileException("Properties doesnt exist");
        }
        //JMeter Engine
        jmeter = new StandardJMeterEngine();
    }

    @BeforeMethod
    public void setupMethod() {
        //JMeter initialization (properties, log levels, locale, etc)
        JMeterUtils.setJMeterHome(jmeterHome.getPath());
        JMeterUtils.loadJMeterProperties(jmeterProperties.getPath());
        JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
        JMeterUtils.initLocale();

        // JMeter Test Plan, basically JOrphan HashTree
        testPlanTree = new HashTree();
    }

    @Test
    public void testMagento() throws IOException {
        // First HTTP Sampler - open Magento
        HTTPSamplerProxy examplecomSampler = new HTTPSamplerProxy();
        examplecomSampler.setDomain("http://192.168.195.210/magento/admin");
        examplecomSampler.setPort(80);
        examplecomSampler.setName("Open magento");

        Arguments arguments = new Arguments();
        arguments.setEnabled(true);
        examplecomSampler.setArguments(arguments);
        examplecomSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        examplecomSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());

        // Loop Controller
        LoopController loopController = new LoopController();
        loopController.setLoops(3);
        loopController.setFirst(true);
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();

        // Thread Group
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Sample Thread Group");
        threadGroup.setNumThreads(30);
        threadGroup.setRampUp(1);
        threadGroup.setSamplerController(loopController);
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());

        TestPlan testPlan = new TestPlan("Create JMeter Script From Java Code");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());

        // Construct Test Plan from previously initialized elements
        testPlanTree.add(testPlan);
        HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
        threadGroupHashTree.add(examplecomSampler);

        // save generated test plan to JMeter's .jmx file format
        SaveService.saveTree(testPlanTree, new FileOutputStream("report\\jmeter_api_sample.jmx"));

        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }
        // Store execution results into a .jtl file, we can save file as csv also
        String reportFile = "report\\report.jtl";
        String csvFile = "report\\report.jtl";
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(reportFile);
        ResultCollector csvlogger = new ResultCollector(summer);
        csvlogger.setFilename(csvFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);
        testPlanTree.add(testPlanTree.getArray()[0], csvlogger);
        // Run Test Plan
        jmeter.configure(testPlanTree);
        jmeter.run();

    }

    @AfterClass
    public void afterTest() {
        System.out.println("Test completed. See " + jmeterHome + slash + "report.jtl file for results");
        System.out.println("JMeter .jmx script is available at " + jmeterHome + slash + "jmeter_api_sample.jmx");
        System.exit(0);
    }
}