package com.bailiban.day4.aop.dynamic_proxy.proxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;
import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
        UserService userServiceOriginal = new UserServiceImpl();
        UserService userServiceProxy = new UserServiceProxy(userServiceOriginal);
        userServiceProxy.getUser();
        userServiceProxy.createUser();
        userServiceProxy.updateUser();
        userServiceProxy.deleteUser();
    }
}
