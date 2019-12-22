package com.bailiban.day4.aop.spring12;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogAdvice implements AfterReturningAdvice {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(dateFormat.format(new Date()) + ": method " + method.getName() + " invoked.");
    }
}
