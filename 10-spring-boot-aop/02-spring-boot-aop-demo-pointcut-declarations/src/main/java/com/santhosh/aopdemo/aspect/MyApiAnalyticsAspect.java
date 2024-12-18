package com.santhosh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.santhosh.aopdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()") // point cut expression
    public void performApiAnalytics() {
        System.out.println("\n==========>>>> Performing API analytics");
    }
}
