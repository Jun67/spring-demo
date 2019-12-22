package com.bailiban.day4.aop.dynamic_proxy.proxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceProxy implements UserService {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void getUser() {
        userService.getUser();
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method getUser invoked.");
    }

    @Override
    public void createUser() {
        userService.createUser();
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method createUser invoked.");
    }

    @Override
    public void updateUser() {
        userService.updateUser();
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method updateUser invoked.");
    }

    @Override
    public void deleteUser() {
        userService.deleteUser();
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method deleteUser invoked.");
    }
}
