package ss.af.reporting.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclarePrecedence;
import org.aspectj.lang.annotation.Pointcut;

import ss.af.reporting.utils.ServerPerfMonitor;

@Aspect
@DeclarePrecedence("ss.af.reporting.aspects.ServerPerfMonAspect,ss.af.reporting.aspects.TraceMethodCallsAspect")
public class ServerPerfMonAspect {
	@Pointcut("execution(@ss.af.reporting.annotations.ServiceReport * *(..))")
	public void serviceReportMethod() {}

	@Before("serviceReportMethod()")
	public void beforeTraceMethods(JoinPoint joinPoint) {	
		String methodName = joinPoint.getSignature().toShortString();
		ServerPerfMonitor.getInstance().logMetrics("Server agent metrics BEFORE "+methodName+": %s");
	}
	@After("serviceReportMethod()")
	public void afterTraceMethods(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		ServerPerfMonitor.getInstance().logMetrics("Server agent metrics AFTER "+methodName+": %s");
	}
}