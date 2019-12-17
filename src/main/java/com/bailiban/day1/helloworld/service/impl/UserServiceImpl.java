package com.bailiban.day1.helloworld.service.impl;

import com.bailiban.day1.helloworld.dao.UserDao;
import com.bailiban.day1.helloworld.model.User;
import com.bailiban.day1.helloworld.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.addUser(user);
    }
}
