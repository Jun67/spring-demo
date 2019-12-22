package com.bailiban.day4.aop.dynamic_proxy.jdkproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;
import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserService userService = UserServiceProxy.newProxyInstance(new UserServiceImpl());
        userService.getUser();
        userService.createUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
