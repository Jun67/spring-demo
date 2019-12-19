package com.bailiban.day3.spring_annotation.autowire.constructor;

import com.bailiban.day3.spring_annotation.autowire.AccountDao;
import com.bailiban.day3.spring_annotation.autowire.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService_constructor")
public class AccountService_Cons implements AccountService {

    private AccountDao accountDao;

    /**
     * 通过构造函数注入
     * @param accountDao
     */
    @Autowired
    public AccountService_Cons(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void create() {
        System.out.println(this.getClass().getAnnotation(Service.class).value());
        accountDao.create();
    }
}
