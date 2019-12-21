package com.bailiban.day4.aop.dynamic_proxy.cglibproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserDao;
import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserDaoImpl;

public class Client {

    public static void main(String[] args) {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\code");
        UserDao userDao = UserDaoCglibProxy.newProxyInstance(new UserDaoImpl());
        userDao.getUser();
        userDao.createUser();
        userDao.updateUser();
        userDao.deleteUser();
    }
}
