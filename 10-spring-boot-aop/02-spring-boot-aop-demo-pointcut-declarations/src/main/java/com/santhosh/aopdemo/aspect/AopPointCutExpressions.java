package com.santhosh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointCutExpressions {
    @Pointcut("execution(* com.santhosh.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // create pointcut for getter methods
    @Pointcut("execution(* com.santhosh.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.santhosh.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
