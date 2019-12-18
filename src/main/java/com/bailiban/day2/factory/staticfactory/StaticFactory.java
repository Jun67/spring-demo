package com.bailiban.day2.factory.staticfactory;

import com.bailiban.day1.helloworld.dao.UserDao;
import com.bailiban.day1.helloworld.dao.impl.UserDaoImpl;
import com.bailiban.day1.helloworld.model.User;

/**
 * 静态工厂方法
 */
public class StaticFactory {

    public static User getUser() {
        return new User(1001, "Jim");
    }

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
