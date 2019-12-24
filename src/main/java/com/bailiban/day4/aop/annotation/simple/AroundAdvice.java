package com.bailiban.day4.aop.annotation.simple;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAdvice {

    @Pointcut("execution(* com..aop.annotation.simple.UserServiceImpl.*(..))")
    public void pc1() {};

    @Around("pc1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开始执行...");
        Object ret = joinPoint.proceed(joinPoint.getArgs());
        System.out.println("结束执行...");
        return ret;
    }
}
