package com.santhosh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.santhosh.aopdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()") // point cut expression
    public void logToCloudAsync() {
        System.out.println("\n==========>>>> Logging to Cloud in async fashion");
    }
}
