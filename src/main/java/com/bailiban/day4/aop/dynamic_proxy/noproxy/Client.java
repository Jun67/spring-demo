package com.bailiban.day4.aop.dynamic_proxy.noproxy;

public class Client {

    public static void main(String[] args) {
        UserService userDao = new UserServiceImpl2();
        userDao.getUser();
        userDao.createUser();
        userDao.updateUser();
        userDao.deleteUser();
    }
}
