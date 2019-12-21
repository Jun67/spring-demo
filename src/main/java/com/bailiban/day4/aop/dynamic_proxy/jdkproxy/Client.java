package com.bailiban.day4.aop.dynamic_proxy.jdkproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserDao;
import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserDaoImpl;

public class Client {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserDao userDao = UserDaoProxy.newProxyInstance(new UserDaoImpl());
        userDao.getUser();
        userDao.createUser();
        userDao.updateUser();
        userDao.deleteUser();
    }
}
