package ss.af.reporting.tests;


public class JUnitAspectTest {
//    @org.junit.Test
    public void doTest() throws InterruptedException {
        System.out.println("JUnit aspect test is running");
        new BusinessLogicMock().doLogic();
    }
}
