package com.softserve.edu.magento.tests;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.gui.HeaderPanel;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.protocol.http.util.HTTPArgument;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import ss.af.reporting.annotations.ServiceReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ProbaJMeterTest {//extends TestBase{
    private File jmeterHome;
    private File jmeterProperties;
    private String slash;
    private StandardJMeterEngine jmeter;

    @BeforeClass
    public void beforeClass() {
        jmeterHome = new File("C:\\Program Files (x86)\\JMeter\\apache-jmeter-3.0");
        slash = System.getProperty("file.separator");
        if (jmeterHome.exists()) {
            jmeterProperties = new File(jmeterHome.getPath() + slash + "bin" + slash + "jmeter.properties");
            if (jmeterProperties.exists()) {

                //JMeter Engine
                jmeter = new StandardJMeterEngine();
            }
        }

    }

    @Test
    // @ServiceReport
    public void jMeterTest() throws Exception {

        //JMeter initialization (properties, log levels, locale, etc)
        JMeterUtils.setJMeterHome(jmeterHome.getPath());
        JMeterUtils.loadJMeterProperties(jmeterProperties.getPath());
        JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
        JMeterUtils.initLocale();

        // JMeter Test Plan, basically JOrphan HashTree
        HashTree testPlanTree = new HashTree();

        // First HTTP Sampler - open google.com
        HTTPSamplerProxy examplecomSampler = new HTTPSamplerProxy();
//        examplecomSampler.setDomain("localhost/Magento/admin_7c8dts");
        examplecomSampler.setDomain("google.com");
        examplecomSampler.setPort(80);
//        examplecomSampler.setName("Open Magento");
        examplecomSampler.setName("Open google.com");
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
        threadGroup.setNumThreads(1);
        threadGroup.setRampUp(1);
        threadGroup.setSamplerController(loopController);
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());

        // Test Plan
        TestPlan testPlan = new TestPlan("Create JMeter Script From Java Code");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());


        // Construct Test Plan from previously initialized elements
        testPlanTree.add(testPlan);
        HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
        threadGroupHashTree.add(examplecomSampler);


        // Second Sampler
        examplecomSampler = new HTTPSamplerProxy();
        examplecomSampler.setDomain("localhost/Magento/admin_7c8dts");
        examplecomSampler.setPort(80);
        examplecomSampler.setName("Login");
        examplecomSampler.setMethod(HTTPSamplerProxy.POST.toString());
        
        examplecomSampler.addArgument("login", "olala");
        examplecomSampler.addArgument("password", "life-1s-good");
//        arguments = new Arguments();
//        arguments.setEnabled(true);
        examplecomSampler.setArguments(arguments);
        examplecomSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        examplecomSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());

        // Add Second Sampler
        threadGroupHashTree.add(examplecomSampler);

        // save generated test plan to JMeter's .jmx file format
        SaveService.saveTree(testPlanTree, new FileOutputStream("report\\jmeter_api_sample2.jmx"));

        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }

        // Store execution results into a .jtl file, we can save file as csv also
        String reportFile = "report\\report2.jtl";
        System.out.println("reportfile");
        String csvFile = "report\\report2.csv";
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(reportFile);
        ResultCollector csvlogger = new ResultCollector(summer);
        csvlogger.setFilename(csvFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);
        testPlanTree.add(testPlanTree.getArray()[0], csvlogger);

        // my code...

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
