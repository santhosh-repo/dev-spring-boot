package com.santhosh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //@Before("execution(public void add*())") // point cut expression modifier is optional
    @Before("execution(* com.santhosh.aopdemo.dao.*.*(..))") // point cut expression
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>>> Executing @Before advice on method");
    }
}
