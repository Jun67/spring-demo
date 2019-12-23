package com.bailiban.day4.aop.spring12.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogInterceptor implements MethodInterceptor {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object ret = invocation.proceed();
        System.out.println(dateFormat.format(new Date()) + ": method " + invocation.getMethod().getName() + " invoked.");
        return null;
    }
}
