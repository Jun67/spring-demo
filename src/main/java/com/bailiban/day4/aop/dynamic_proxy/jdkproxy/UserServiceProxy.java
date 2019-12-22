package com.bailiban.day4.aop.dynamic_proxy.jdkproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceProxy {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static UserService newProxyInstance(UserService userService) {
        return (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), (o, method, objects) -> {
                    Object ret = method.invoke(userService, objects);
                    System.out.println(dateFormat.format(new Date()) + ": method " + method.getName() + " invoked");
                    return ret;
                });
    }
}
