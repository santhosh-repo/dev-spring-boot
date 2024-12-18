package com.luv2code.springboot.thymeleafdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    // setup pointcut for controller package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}
    // setup pointcut for service package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}
    // setup pointcut for dao package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}



    // combine pointcut declarations
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}


    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        // display the method we are calling

        String theMethod = theJoinPoint.getSignature().toShortString();

        myLogger.info("======> in @Before calling method: " + theMethod);

        // display the arguments to the method

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            myLogger.info("======> argument: " + tempArg);
        }

    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

        // display the method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("======> in @AfterReturning from method: " + theMethod);

        // display data returned
        myLogger.info("======> result: " + theResult);

    }


}

















