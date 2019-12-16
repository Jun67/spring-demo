package com.bailiban.day1.helloworld.dao.impl;

import com.bailiban.day1.helloworld.dao.UserDao;
import com.bailiban.day1.helloworld.model.User;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        System.out.println("用户添加成功：" + user);
    }
}
