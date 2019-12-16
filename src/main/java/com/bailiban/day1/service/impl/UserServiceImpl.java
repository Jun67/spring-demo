package com.bailiban.day1.service.impl;

import com.bailiban.day1.dao.UserDao;
import com.bailiban.day1.model.User;
import com.bailiban.day1.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.addUser(user);
    }
}
