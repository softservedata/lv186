package com.softserve.edu.magento.tests;

//import core.WebDriverManager;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.customer.ApplicationCustomer;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import ss.af.reporting.AutomationSuiteContext;
import ss.af.reporting.GenericReportsFactory;
import ss.af.reporting.HtmlReportSettings;
import ss.af.reporting.ReportListenerLevel;
import ss.af.reporting.SuiteReportChain;
import ss.af.reporting.TestReport;
import ss.af.reporting.TestReportFactory;
import ss.af.reporting.baseclasses.AutoTestWithReporting;
import ss.af.reporting.utils.Utils;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by pfatula on 06.09.2016
 */
public class TestBase extends AutoTestWithReporting {

    private static final String REPORTS_PATH = ".//reports//";
    private String currentTestName;
    private static HashMap<String,Integer> testRunHistory = new HashMap<String,Integer>();

    public static final String YOUR_PROJECT_NAME = "MAGENTO_POC";
    public static final String YOUR_SUITE_NAME = "POC_SUITE";
    public static final String YOUR_AUTOMATION_SUITE_DESCRIPTION = "proof of concept";
    public static final String YOUR_AUTOMATION_TEST_DESCRIPTION = "proof of concept";

    /*
     * Set-up method for test suite.
     * If you use test suites it should be moved there.
     * Otherwise move it to superclass (and then every test class  will be a "test suite").
     */
    @BeforeSuite
    @Parameters("browser")
    public void suiteSetup(String browser){
        //WebDriver driver = WebDriverManager.createInstanceFor(browser);
        //driver.manage().window().maximize();

        String projectName = YOUR_PROJECT_NAME;
        String suiteName = YOUR_SUITE_NAME;
        AutomationSuiteContext.getInstance().initialize(projectName, suiteName, 1);
        SuiteReportChain suiteReportChain = new SuiteReportChain();
        HtmlReportSettings htmlSettings = new HtmlReportSettings();
        htmlSettings.setReportDescription(YOUR_AUTOMATION_SUITE_DESCRIPTION);
        htmlSettings.setReportFolder(REPORTS_PATH);
        // Html
        TestReportFactory htmlFactory = GenericReportsFactory.createHtmlReport(htmlSettings);
        suiteReportChain.addReport(htmlFactory.getSuiteReport(projectName, suiteName));
        AutomationSuiteContext.getInstance().setSuiteReport(suiteReportChain);
        AutomationSuiteContext.getInstance().getSuiteReport().setup(ReportListenerLevel.OnlyTestResults);
    }
    /*
    * Set-up method for test case. Should be moved to superclass.
    */
    @BeforeMethod
    public void testSetup(Method method){
        currentTestName = resolveMetodName(method);
        this.defaultInitialize();
        HtmlReportSettings htmlSettings = new HtmlReportSettings();
        htmlSettings.setReportDescription(YOUR_AUTOMATION_TEST_DESCRIPTION);
        htmlSettings.setReportFolder(REPORTS_PATH);
        TestReportFactory htmlFactory = GenericReportsFactory.createHtmlReport(htmlSettings);
        TestReport htmlReport = htmlFactory.getTestReport(currentTestName);
        getTestReport().addReport(htmlReport);
        getTestReport().setup(ReportListenerLevel.All, Utils.getSystemGeneralInfo());
    }

    @AfterMethod
    public void testTearDown(ITestResult testResult) {
        if(testResult!=null){
            boolean passed = testResult.isSuccess();
            writeTestResults(passed);
        }else{
            throw new RuntimeException("TestResult is null!");
        }
    }
    /*
    * Tear-down method for test suite.
    * If you use test suites it should be moved there.
    * Otherwise move it to superclass (and then every test class  will be a "test suite").
    */
    @AfterSuite
    public void suiteTearDown(){
        AutomationSuiteContext.getInstance().getSuiteReport().closeReport();
    }
    /*
    * TestNG specific implementation of abstract method from AutoTestWithReporting class
    */
    @Override
    public String getTestName() {
        return currentTestName;
    }
    /*
    * Writes test case result. Should be moved to superclass.
    */
    private void writeTestResults(boolean passed){
        getTestReport().writeTestResult(passed, "Test result message");
        this.cleanup(currentTestName, passed, null);
    }
    private String resolveMetodName(Method method) {
        String name = method.getName();
        Integer runCount = testRunHistory.get(name);
        if(runCount == null){
            testRunHistory.put(name, 1);
        }else{
            runCount++;
            testRunHistory.put(name,runCount);
            name+="_run"+runCount;
        }
        return name;
    }
}
