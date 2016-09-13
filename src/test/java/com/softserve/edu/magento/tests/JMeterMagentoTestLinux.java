package com.softserve.edu.magento.tests;

import com.sun.syndication.io.impl.PluginManager;
import kg.apc.jmeter.reporters.LoadosophiaUploader;
import kg.apc.jmeter.reporters.LoadosophiaUploaderGui;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.JMeterEngine;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.*;
import org.apache.jmeter.protocol.http.control.gui.RecordController;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.gui.CacheManagerGui;
import org.apache.jmeter.protocol.http.gui.CookiePanel;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.visualizers.ViewResultsFullVisualizer;
import org.apache.jorphan.collections.HashTree;
import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.plugin.navig.motif.Plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.NoSuchFileException;

/**
 * Created by bohdan on 24.08.16.
 */
public class JMeterMagentoTestLinux {
    public final static String UPLOAD_TOKEN = "LS0tLS1CRUdJTiBSU0EgUFJJVkFURSBLRVktLS0tLQ0KTUdJQ0FRQUNFUUNKNkFrYW9pNHY4aU1ZcmNWaXNlMGpBZ01CQUFFQ0VDRTVGY3hsU3VSQXdHS0tKTkEzdVhVQw0KQ1FDWmlyczJHTFVjN3dJSkFPWHVVU0hZTWRzTkFnZ1VKZmhiS1BMYlVRSUpBSUh4MDZ4YThLSXBBZ2hhS1hDQg0KTVNZZFB3PT0NCi0tLS0tRU5EIFJTQSBQUklW";
    private File jmeterProperties;
    private File jmeterHome;
    private String slash;
    private StandardJMeterEngine jmeter;
    private HashTree testPlanTree;

    //Set jmeter home for the jmeter utils to load
    @BeforeClass
    public void setupClass() throws NoSuchFileException {
        jmeterHome = new File("/home/bohdan/Downloads/apache-jmeter-3.0");
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
        JMeterUtils.getPropDefault("jmeterengine.startlistenerslater", false);
        // JMeter Test Plan, basically JOrphan HashTree
        testPlanTree = new HashTree();
    }

    @Test
    public void testMagento() throws Exception {
        // First HTTP Sampler - open google.com
        HTTPSamplerProxy examplecomSampler = new HTTPSamplerProxy();
        examplecomSampler.setDomain("localhost/magento2/");
        //examplecomSampler.setDomain("google.com");
        examplecomSampler.setPort(80);
        examplecomSampler.setMethod("GET");
        examplecomSampler.setName("Open magento");
        Arguments arguments = new Arguments();
        arguments.setEnabled(true);
        examplecomSampler.setArguments(arguments);
        examplecomSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        examplecomSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
        // Cache Manager
        CacheManager cacheManager = new CacheManager();
        cacheManager.setName("cache");
        cacheManager.setMaxSize(5000);
        cacheManager.setProperty(TestElement.TEST_CLASS, CacheManager.class.getName());
        cacheManager.setProperty(TestElement.GUI_CLASS, CacheManagerGui.class.getName());
        // Cookie Manager
        CookieManager cookieManager = new CookieManager();
        cookieManager.setName("cookie");
        cookieManager.setImplementation("HC4CookieHandler");
        cookieManager.setClearEachIteration(false);
        cookieManager.setCookiePolicy("standard");
        cookieManager.setProperty(TestElement.TEST_CLASS, CookieManager.class.getName());
        cookieManager.setProperty(TestElement.GUI_CLASS, CookiePanel.class.getName());
        // Loop Controller
        LoopController loopController = new LoopController();
        loopController.setLoops(3);
        loopController.setFirst(true);
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();
        // Loadsophia
        LoadosophiaUploader loadosophiaUploader = new LoadosophiaUploader();
        loadosophiaUploader.setName("bzm - BlazeMeter Sense Uploader");
        loadosophiaUploader.setProject("DEFAULT");
        loadosophiaUploader.setUploadToken(UPLOAD_TOKEN);
        loadosophiaUploader.setStoreDir("/home/bohdan/Downloads/apache-jmeter-3.0/");
        loadosophiaUploader.setColorFlag("red");
        loadosophiaUploader.setTitle("Test 1");
        loadosophiaUploader.setUseOnline(true);
        loadosophiaUploader.setProperty(TestElement.TEST_CLASS, LoadosophiaUploader.class.getName());
        loadosophiaUploader.setProperty(TestElement.GUI_CLASS, LoadosophiaUploaderGui.class.getName());

        // Thread Group
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Sample Thread Group");
        threadGroup.setNumThreads(5);
        threadGroup.setRampUp(5);
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
        threadGroupHashTree.add(cacheManager);
        threadGroupHashTree.add(cookieManager);
        threadGroupHashTree.add(examplecomSampler);
        threadGroupHashTree.add(loadosophiaUploader);

        // save generated test plan to JMeter's .jmx file format
        SaveService.saveTree(testPlanTree, new FileOutputStream("/home/bohdan/Downloads/apache-jmeter-3.0/jmeter_api_sample.jmx"));

        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }
        // Store execution results into a .jtl file, we can save file as csv also
        String reportFile = "/home/bohdan/Downloads/apache-jmeter-3.0/report.jtl";
        String csvFile = "/home/bohdan/Downloads/apache-jmeter-3.0/report.csv";
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(reportFile);
        ResultCollector csvlogger = new ResultCollector(summer);
        csvlogger.setFilename(csvFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);
        testPlanTree.add(testPlanTree.getArray()[0], csvlogger);
        // Run Test Plan
        jmeter.configure(testPlanTree);
        jmeter.run();
        System.out.println("Test completed. See " + jmeterHome + slash + "report.jtl file for results");
        System.out.println("JMeter .jmx script is available at " + jmeterHome + slash + "jmeter_api_sample.jmx");
        System.exit(0);
    }

}

