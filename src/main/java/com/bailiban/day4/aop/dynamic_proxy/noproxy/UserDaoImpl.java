package com.bailiban.day4.aop.dynamic_proxy.noproxy;

public class UserDaoImpl implements UserDao{

    @Override
    public void getUser() {
        System.out.println("getUser");
    }

    @Override
    public void createUser() {
        System.out.println("createUser");
    }

    @Override
    public void updateUser() {
        System.out.println("updateUser");
    }

    @Override
    public void deleteUser() {
        System.out.println("deleteUser");
    }
}
