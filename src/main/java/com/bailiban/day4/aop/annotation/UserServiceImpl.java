package com.bailiban.day4.aop.annotation;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

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
