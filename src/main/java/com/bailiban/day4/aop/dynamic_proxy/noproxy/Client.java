package com.bailiban.day4.aop.dynamic_proxy.noproxy;

public class Client {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl2();
        userService.getUser();
        userService.createUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
