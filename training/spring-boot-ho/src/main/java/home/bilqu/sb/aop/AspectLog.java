package home.bilqu.sb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectLog {
	
	private final Logger LOG = LoggerFactory.getLogger(AspectLog.class);
	
	@Before("execution(* home.bilqu.sb..*.*(..))")
	public void before(JoinPoint joinPoint) {
		LOG.info("I am printing before execution of {}",joinPoint);
		
		StringBuilder builder = new StringBuilder();
		builder.append("Before: " );
		builder.append(joinPoint).append(" on ").append(joinPoint.getTarget()).append(" Arguments : ");
		Object[] arguments = joinPoint.getArgs();
		for(Object arg: arguments)
			builder.append(arg.toString());
		LOG.info(builder.toString());
		
	}
	
	@After("execution(* home.bilqu.sb..*.*(..))")
	public void after(JoinPoint joinPoint) {
		LOG.info("I am printing after execution of {}",joinPoint);
		StringBuilder builder = new StringBuilder();
		builder.append("After: " );
		builder.append(joinPoint).append(" on ").append(joinPoint.getTarget()).append(" Arguments : ");
		Object[] arguments = joinPoint.getArgs();
		for(Object arg: arguments)
			builder.append(arg.toString());
		LOG.info(builder.toString());
	}
	
	@Around("execution(* home.bilqu.sb..*.*(..))")
	public void around(final ProceedingJoinPoint jointPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = jointPoint.proceed();
		
		StringBuilder builder = new StringBuilder();
		builder.append("Around: " );
		builder.append(jointPoint).append(" on ").append(jointPoint.getTarget()).append(" Arguments : ");
		Object[] arguments = jointPoint.getArgs();
		for(Object arg: arguments)
			builder.append(arg.toString());
		builder.append(" Result : " ).append(result);
		builder.append(" Completed in : " ).append((System.currentTimeMillis() - start)).append("s");
		
		LOG.info(builder.toString());
	}

//	@AfterThrowing("execution(* home.bilqu.sb..*.*(..))")
//	public void afterThrowing(Exception ex) {
//		ex.printStackTrace();
//	}
	
//	@Around("call(public void org.apache.log4j.Logger.info(Object)) && args(msg) && !within(AspectLog)")
//	public Object formatMessage(final Object msg, final ProceedingJoinPoint invocation, final JoinPoint.EnclosingStaticPart callerContext) throws Throwable {
//		return formatAndProceed(msg, null, invocation, callerContext);
//	}
//
//	@Around("call(public void org.apache.log4j.Logger.info(Object)) && args(msg) && !within(AspectLog)")
//	public Object formatMessage(final Object msg, final Throwable exception, final ProceedingJoinPoint invocation, final JoinPoint.EnclosingStaticPart callerContext) throws Throwable {
//		return formatAndProceed(msg, exception, invocation, callerContext);
//	}

	private Object formatAndProceed(final Object msg, final Throwable exception, final ProceedingJoinPoint invocation, final JoinPoint.EnclosingStaticPart callerContext) throws Throwable {
		final String callingMethod = callerContext.getSignature().getName();
		LOG.info("\nmethod: " + callingMethod +"\nmessage: " + msg + "\nexception: " + exception);
		final Object[] arguments = invocation.getArgs();
		arguments[0] = formatMessage(callingMethod, msg);
		return invocation.proceed(arguments);
	}

	private String formatMessage(final String callingMethod,final Object originalMessage) {
		return "APPMSG: " + callingMethod + ": " + originalMessage;
	}
	
	



}
