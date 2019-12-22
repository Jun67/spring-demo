package com.bailiban.day4.aop.dynamic_proxy.cglibproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceCglibProxy {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 返回动态代理对象
     * @param userService 被代理对象
     * @return 代理对象
     */
    public static UserService newProxyInstance(UserService userService) {

        /*
         * Enhancer.create方法返回动态生成的代理类
         * 参数：
         *  userService.getClass()：被代理类的类；
         *  第二个参数定义了一个内部类，实现了代理逻辑，内部参数：
         *      o：代理类对象；
         *      method：被代理方法；
         *      objects：被代理方法的参数；
         *      methodProxy：方法代理；
         */
        return (UserService) Enhancer.create(userService.getClass(), (MethodInterceptor) (o, method, objects, methodProxy) -> {
            // 调用被代理方法
            Object ret = methodProxy.invokeSuper(o, objects);
            // 编写增强功能
            System.out.println(dateFormat.format(new Date()) + ": method " + method.getName() + " invoked");
            return ret;
        });
    }
}
