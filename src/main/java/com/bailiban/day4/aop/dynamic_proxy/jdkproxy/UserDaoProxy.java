package com.bailiban.day4.aop.dynamic_proxy.jdkproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserDao;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoProxy {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static UserDao newProxyInstance(UserDao userDao) {
        return (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(), (o, method, objects) -> {
                    Object ret = method.invoke(userDao, objects);
                    System.out.println(dateFormat.format(new Date()) + ": method " + method.getName() + " invoked");
                    return ret;
                });
    }
}
