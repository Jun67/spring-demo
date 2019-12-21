package com.bailiban.day4.aop.dynamic_proxy.cglibproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserDao;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoCglibProxy {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static UserDao newProxyInstance(UserDao userDao) {
        return (UserDao) Enhancer.create(userDao.getClass(), (MethodInterceptor) (o, method, objects, methodProxy) -> {
            Object ret = methodProxy.invokeSuper(o, objects);
            System.out.println(dateFormat.format(new Date()) + ": method " + method.getName() + " invoked");
            return ret;
        });
    }
}
