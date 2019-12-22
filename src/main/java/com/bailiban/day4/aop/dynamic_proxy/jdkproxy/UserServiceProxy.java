package com.bailiban.day4.aop.dynamic_proxy.jdkproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceProxy {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 返回动态代理对象
     * @param userService 被代理对象
     * @return 代理对象
     */
    public static UserService newProxyInstance(UserService userService) {
            /*
             * Proxy.newProxyInstance方法返回动态生成的代理类
             * 参数：
             *  userService.getClass().getClassLoader()：被代理类的类加载器；
             *  userService.getClass().getInterfaces()：被代理类的接口，重要！说明JDK动态代理是基于代理接口的。
             *  第三个参数定义了一个内部类，实现了代理逻辑，内部参数：
             *      o：代理类对象；
             *      method：被代理方法；
             *      objects：被代理方法的参数；
             */
            return (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                    userService.getClass().getInterfaces(), (o, method, objects) -> {
                        // 调用被代理方法
                        Object ret = method.invoke(userService, objects);
                        // 编写增强功能
                        System.out.println(dateFormat.format(new Date()) + ": method " + method.getName() + " invoked");
                        return ret;
                    });
        }
}
