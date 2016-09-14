package ss.af.reporting.tests;


public class TestNGAspectTest {

//    @org.testng.annotations.BeforeSuite
    public void beforeSuite() {
        //		TODO
    }

//    @org.testng.annotations.BeforeMethod
    public void beforeMethod() {
//		HtmlReportSettings htmlSettings = new HtmlReportSettings
//		{
//	ReportDescription = "Some description",
//			ReportFolder = Path.Combine(Environment.CurrentDirectory, "Reports")
//		};
//
//		ITestReportFactory htmlFactory = GenericReportsFactory.createHtmlReport(htmlSettings);
//		ITestReport htmlReport = htmlFactory.getTestReport(TestContext.CurrentContext.Test.Name);
    }

//    @org.testng.annotations.Test
    public void doTest() throws InterruptedException {
        System.out.println("TestNG aspect test is running");
        new BusinessLogicMock().doLogic();
    }

//    @org.testng.annotations.AfterMethod
    public void afterMethod() {
        //		TODO
    }

//    @org.testng.annotations.AfterSuite
    public void afterSuite() {
        //		TODO
    }
}
