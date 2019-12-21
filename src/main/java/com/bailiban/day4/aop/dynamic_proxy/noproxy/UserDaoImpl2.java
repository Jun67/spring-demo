package com.bailiban.day4.aop.dynamic_proxy.noproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoImpl2 {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    void getUser() {
        System.out.println("getUser");
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method getUser invoked.");
    }

    void createUser() {
        System.out.println("createUser");
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method createUser invoked.");
    }

    void updateUser() {
        System.out.println("updateUser");
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method updateUser invoked.");
    }

    void deleteUser() {
        System.out.println("deleteUser");
        System.out.println(dateFormat.format(new Date()).toString() +  " Log: method deleteUser invoked.");
    }
}
