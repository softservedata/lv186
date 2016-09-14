package ss.af.reporting.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import ss.af.reporting.TestReport;
import ss.af.reporting.baseclasses.AutoTestWithReporting;
import ss.af.reporting.utils.Utils;

import java.awt.image.BufferedImage;

@Aspect
public class TraceExceptionsAspect {

    @AfterThrowing(pointcut = "execution(@org.testng.annotations.Test * *(..))", throwing = "e")
    public void onTestNGException(JoinPoint joinPoint, Throwable e) {
        handleException(joinPoint, e);
    }

    @AfterThrowing(pointcut = "execution(@org.junit.Test * *(..))", throwing = "e")
    public void onJUnitException(JoinPoint joinPoint, Throwable e) {
        handleException(joinPoint, e);
    }

    private void handleException(JoinPoint joinPoint, Throwable e) {
        String message = String.format("\"%s\"\nStackTrace:\n%s", e.getMessage(), Utils.getStackTrace(e));
        TestReport report = getReport(joinPoint, e);
        if (report != null) {
            BufferedImage bitmap = Utils.doScreen();
            report.logError(message);
            report.logImage(bitmap);
        }
    }

    private TestReport getReport(JoinPoint joinPoint, Throwable topExcpt) {
        TestReport report = null;
        try {
            AutoTestWithReporting test = (AutoTestWithReporting) joinPoint.getTarget();
            report = test.getTestReport();
        } catch (IllegalArgumentException | SecurityException | ClassCastException e) {
            String msg = String.format(
                    "Failed to report the exception:\n\t'%s'\n"
                            + "From:\n\t'%s'\n"
                            + "Does it extend AutoTestWithReporting class?",
                    topExcpt.toString(),
                    joinPoint.getSignature());
            System.err.println(msg); //TODO any logging?
            topExcpt.printStackTrace();
            e.printStackTrace();
        }
        return report;
    }
}
