package com.stackroute.keepnote.aspectj;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/* Annotate this class with @Aspect and @Component */

@Aspect
@Component
public class LoggingAspect {
	/*
	 * Write loggers for each of the methods of Category controller, any particular method
	 * will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */
	
private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.stackroute.keepnote.controller.CategoryController.createCategory(..))")
	public void logBeforecreateCategory(JoinPoint joinPoint) {

		logger.info("============@Before==========");
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("*********************************");

	}
	
	@After("execution(* com.stackroute.keepnote.controller.CategoryController.createCategory(..))")
	public void logAftercreateCategory(JoinPoint joinPoint) {

		logger.info("============@After==========");
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
		logger.debug("*********************************");

	}
	
	@AfterReturning(pointcut = "execution(* com.stackroute.keepnote.controller.CategoryController.createCategory(..))", returning = "result")
	public void logAfterReturningcreateCategory(JoinPoint joinPoint, Object result) {

		logger.debug("============@AfterReturning==========");
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
		logger.debug("*********************************");

	}
	
	@AfterThrowing(pointcut = "execution(* com.stackroute.keepnote.controller.CategoryController.createCategory(..))", throwing = "error")
	public void logAfterThrowingcreateCategory(JoinPoint joinPoint, Throwable error) {

		logger.info("============@AfterThrowing==========");
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
		logger.debug("*********************************");
	}
}
