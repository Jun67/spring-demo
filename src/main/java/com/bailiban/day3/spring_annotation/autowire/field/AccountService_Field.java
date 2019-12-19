package com.bailiban.day3.spring_annotation.autowire.field;

import com.bailiban.day3.spring_annotation.autowire.AccountDao;
import com.bailiban.day3.spring_annotation.autowire.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService_field")
public class AccountService_Field implements AccountService {

    // 通过属性注入
    @Autowired
    private AccountDao accountDao;

    public void create() {
        System.out.println(this.getClass().getAnnotation(Service.class).value());
        accountDao.create();
    }
}
