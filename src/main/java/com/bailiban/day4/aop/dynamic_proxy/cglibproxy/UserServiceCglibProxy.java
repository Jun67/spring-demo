package com.bailiban.day4.aop.dynamic_proxy.cglibproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceCglibProxy {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static UserService newProxyInstance(UserService userService) {
        return (UserService) Enhancer.create(userService.getClass(), (MethodInterceptor) (o, method, objects, methodProxy) -> {
            Object ret = methodProxy.invokeSuper(o, objects);
            System.out.println(dateFormat.format(new Date()) + ": method " + method.getName() + " invoked");
            return ret;
        });
    }
}
