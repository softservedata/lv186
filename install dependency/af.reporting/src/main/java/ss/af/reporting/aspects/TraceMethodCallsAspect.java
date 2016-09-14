package ss.af.reporting.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.aspectj.lang.reflect.MethodSignature;

import ss.af.reporting.AutomationSuiteContext;
import ss.af.reporting.annotations.ServiceReport;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.logging.Level;

@Aspect
public class TraceMethodCallsAspect {
    private LinkedList<Long> methodStartTimes;
    private LinkedList<String> methodNames;
    private boolean reportParameterValues;
    private boolean collectStatistics;
    private Level traceEventType;
    private static final int INFO = 800;
    private static final int WARNING = 900;
    private static final int SEVERE = 1000;

    public TraceMethodCallsAspect() {
        methodNames = new LinkedList<String>();
        methodStartTimes = new LinkedList<Long>();
        collectStatistics = true;
        reportParameterValues = true;
        traceEventType = Level.FINE;  // "VERBOSE" = 500;
    }

    @SuppressAjWarnings
    @Pointcut("execution(@org.junit.Test * *(..))")
    public void junitTestProfilerMethod() {
    }

    @SuppressAjWarnings
    @Pointcut("execution(@org.testng.annotations.Test * *(..))")
    public void testNGProfilerMethod() {
    }

    @Pointcut("execution(@ss.af.reporting.annotations.ServiceReport * *(..))")
    public void serviceReportMethod() {
    }

    @Before("junitTestProfilerMethod()  || testNGProfilerMethod() || serviceReportMethod()")
    public void beforeTraceMethods(JoinPoint joinPoint) {
        String[] s = joinPoint.getSignature().toString().split("\\.");
        String methodShortSignature = String.format("%s.%s", s[s.length - 2], s[s.length - 1]); //removing package declaration
        methodNames.push(methodShortSignature);
        methodStartTimes.push(System.currentTimeMillis());
    }

    @After("junitTestProfilerMethod()  || testNGProfilerMethod() || serviceReportMethod()")
    public void afterTraceMethods(JoinPoint joinPoint) {
        String methodShortSignature = methodNames.pop();
        long durationInMillis = System.currentTimeMillis() - methodStartTimes.pop();
        //		String duration = formatTime(durationInMillis);
        String testName = AutomationSuiteContext.getInstance().getCurrentExecutedTest().getTestName();
        
        MethodSignature testMethodSignature = (MethodSignature) joinPoint.getSignature();
        Method testMethod = testMethodSignature.getMethod();
        Annotation[] declaredAnnotations = testMethod.getDeclaredAnnotations();

        boolean containServiceReportAnnotation = containServiceReportAnnotation(declaredAnnotations);
        if (collectStatistics && containServiceReportAnnotation) {
            AutomationSuiteContext.getInstance().getStatisticsCollector()
                    .incrementMethodCall(methodShortSignature, testName, durationInMillis);
        }

        String methodName = testMethod.getDeclaringClass().getSimpleName() +"."+ testMethod.getName();
        StringBuilder parameters = new StringBuilder();
        if (reportParameterValues) {
            Object[] methodArguments = joinPoint.getArgs();
            parameters.append("(");
            if (methodArguments.length > 0) {
                boolean first = true;
                for (Object arg : methodArguments) {
                    if (!first) {
                        parameters.append(", ");
                    } else {
                        first = false;
                    }
                    if (arg instanceof String) {
                        parameters.append("\"" + arg + "\"");
                    } else {
                        parameters.append(arg);
                    }
                }
            }
            parameters.append(")");
        }

        String methodInfo = methodName + parameters;

        String finalMessage = String.format("%s Elapsed = %d ms.", methodInfo, durationInMillis);

        switch (traceEventType.intValue()) {
            case INFO:
                AutomationSuiteContext.getInstance().getCurrentExecutedTest().getTestReport().logInfo(finalMessage);
                break;
            case WARNING:
                AutomationSuiteContext.getInstance().getCurrentExecutedTest().getTestReport().logWarning(finalMessage);
                break;
            case SEVERE:
                AutomationSuiteContext.getInstance().getCurrentExecutedTest().getTestReport().logError(finalMessage);
                break;
            default:
                AutomationSuiteContext.getInstance().getCurrentExecutedTest().getTestReport().logVerbose(finalMessage);
                break;
        }
    }

    private boolean containServiceReportAnnotation(Annotation[] declaredAnnotations) {
        boolean contains = false;
        for (Annotation ann : declaredAnnotations) {
            if (ann instanceof ServiceReport) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public boolean isReportParameterValues() {
        return reportParameterValues;
    }

    public void setReportParameterValues(boolean reportParameterValues) {
        this.reportParameterValues = reportParameterValues;
    }
}
