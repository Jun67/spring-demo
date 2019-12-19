package com.bailiban.day3.spring_annotation.autowire.setter;

import com.bailiban.day3.spring_annotation.autowire.AccountDao;
import com.bailiban.day3.spring_annotation.autowire.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Service：一般用于服务层；
 */
@Service("accountService_setter")
public class AccountService_Setter implements AccountService {

    private AccountDao accountDao;

    /**
     * 通过setter方法注入
     * @param accountDao
     */
    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void create() {
        System.out.println(this.getClass().getAnnotation(Service.class).value());
        accountDao.create();
    }
}
