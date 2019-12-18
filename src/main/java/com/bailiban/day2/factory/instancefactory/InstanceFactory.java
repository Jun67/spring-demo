package com.bailiban.day2.factory.instancefactory;

import com.bailiban.day1.helloworld.dao.UserDao;
import com.bailiban.day1.helloworld.dao.impl.UserDaoImpl;
import com.bailiban.day1.helloworld.model.User;

/**
 * 实例工厂方法
 */
public class InstanceFactory {

    public User getUser() {
        return new User(1001, "Jim");
    }

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
