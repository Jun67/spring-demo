package com.bailiban.day4.aop.aopxml;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开始执行...");
        Object ret = joinPoint.proceed(joinPoint.getArgs());
        System.out.println("结束执行...");
        return ret;
    }
}
