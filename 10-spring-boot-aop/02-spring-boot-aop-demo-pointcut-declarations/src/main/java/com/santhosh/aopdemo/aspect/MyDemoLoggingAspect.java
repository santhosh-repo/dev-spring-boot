package com.santhosh.aopdemo.aspect;

import com.santhosh.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @Around

    @Around("execution(* com.santhosh.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // print out the method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();

        System.out.println("\n==========>>>> Executing @Around advice on method " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;
        try {
            result =  proceedingJoinPoint.proceed();
        }catch(Exception e) {

             System.out.println(e.getMessage());

             // give user a custom message
            // result = "Major Accident No Worries";
            // rethrow exception
            throw e;
        }


        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end- begin;

        System.out.println("Duration ::: " +  duration / 1000.0 + " seconds");

        return result;

    }


    @After("execution(* com.santhosh.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice( JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n==========>>>> Executing @After (finally) advice on method " + method);

    }



    // add a new advice for @AfterThrowing on the method findAccounts

    @AfterThrowing(
            pointcut = "execution(* com.santhosh.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint  joinPoint , Throwable theExc){

        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n==========>>>> Executing @AfterThrowing advice on method " + method);

        System.out.println("\n==========>>>> Exception is ::  " + theExc);


    }


    // add a new advice for @AfterReturning on the method findAccounts

    @AfterReturning(
            pointcut = "execution(* com.santhosh.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,  List<Account> result) {

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n==========>>>> Executing @AfterReturning advice on method " + method);

        // add some code to modify the result
        System.out.println("\n==========>>>> result::  " + result);

        convertAccountNamesToUpperCase(result);

       /* if (result != null) {
            Account tempAccount = result.get(0);
            tempAccount.setName("Daffy Duck");
        }*/
        System.out.println("\n==========>>>> result uppercase::  " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }


    @Before("com.santhosh.aopdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()") // point cut expression
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n==========>>>> Executing @Before advice on method");
        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {

            System.out.println(arg);

            if (arg instanceof Account) {

                Account theAccount = (Account) arg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());

            }
        }

    }
}
