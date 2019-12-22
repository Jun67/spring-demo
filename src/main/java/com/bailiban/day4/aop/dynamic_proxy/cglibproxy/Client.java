package com.bailiban.day4.aop.dynamic_proxy.cglibproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;
import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
        // 保存动态生成的代理类的字节码
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\code");
        UserService userService = UserServiceCglibProxy.newProxyInstance(new UserServiceImpl());
        userService.getUser();
        userService.createUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
