package com.bailiban.day4.aop.dynamic_proxy.noproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceImpl2 implements UserService {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void getUser() {
        System.out.println("getUser");
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method getUser invoked.");
    }

    @Override
    public void createUser() {
        System.out.println("createUser");
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method createUser invoked.");
    }

    @Override
    public void updateUser() {
        System.out.println("updateUser");
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method updateUser invoked.");
    }

    @Override
    public void deleteUser() {
        System.out.println("deleteUser");
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method deleteUser invoked.");
    }
}
