package af.core.tests;
// imports 
/*
* A JUnit specific test_suite/test_class implementation
* Move inheritance from AutoTestWithReporting class to your superclass
*/
public abstract class JunitTests extends AutoTestWithReporting{
	private static final String REPORTS_PATH = ".//reports//";

	public static final String YOUR_PROJECT_NAME = "";
	public static final String YOUR_SUITE_NAME = "";
	public static final String YOUR_AUTOMATION_SUITE_DESCRIPTION = "";
	public static final String YOUR_AUTOMATION_TEST_DESCRIPTION = "";
	
	@Rule 
	public TestName name = new TestName();
	@Rule 
	public TestWatcher watcher = new TestWatcher(){
		@Override
 		protected void succeeded(Description d) {
			writeTestResult(true);
 		}
 		@Override
		protected void failed(Throwable e, Description description) {
 			writeTestResult(false);
		}
 	};

	/*
	* Set-up method for test suite. 
	* If you use test suites it should be moved there. 
	* Otherwise move it to superclass (and then every test class  will be a "test suite").
	*/
	@BeforeClass
	public static void suiteSetup(){
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
	@Before
	public void testSetup(){
		this.defaultInitialize();
		HtmlReportSettings htmlSettings = new HtmlReportSettings();
		htmlSettings.setReportDescription(YOUR_AUTOMATION_TEST_DESCRIPTION);
		htmlSettings.setReportFolder(REPORTS_PATH);

		TestReportFactory htmlFactory = GenericReportsFactory.createHtmlReport(htmlSettings);
		TestReport htmlReport = htmlFactory.getTestReport(name.getMethodName()); 

		getTestReport().addReport(htmlReport);
		getTestReport().setup(ReportListenerLevel.All, ss.af.reporting.utils.Utils.getSystemGeneralInfo());
	}

	@After
	public void testTearDown(){
		//Tear-down logic
	}
	/*
	* Writes test case result. Should be moved to superclass.
	*/
	private void writeTestResult(boolean passed){
		String testName = name.getMethodName();
		getTestReport().writeTestResult(passed, "Test result message");
		this.cleanup(testName, passed, null);
	}
	/*
	* Tear-down method for test suite. 
	* If you use test suites it should be moved there. 
	* Otherwise move it to superclass (and then every test class  will be a "test suite").
	*/
	@AfterClass
	public static void suiteTearDown(){
		AutomationSuiteContext.getInstance().getSuiteReport().closeReport();
	}
	/*
	* JUnit specific implementation of abstract method from AutoTestWithReporting class
	*/
	@Override
	public String getTestName() {
		return name.getMethodName();
	}
}
