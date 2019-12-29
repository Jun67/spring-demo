package com.bailiban.day5.transaction.transfer.annotation;

import com.bailiban.day4.account_system.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Autowired
    private AccountService2 service2;

    @Transactional
    public void transfer(int fromId, int toId, double money) {

        accountDao.getJdbcTemplate().update("update account set money = 100 where id = 3");

        try {
            Account fromAccount = accountDao.findById(fromId);
            Account toAccount = accountDao.findById(toId);
            toAccount.setMoney(toAccount.getMoney() + money);
            service2.update(toAccount);
            fromAccount.setMoney(fromAccount.getMoney() - money);
            service2.update(fromAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int i = 1/0;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Account get(int id) {
        Account account = accountDao.findById(id);
        System.out.println(account);
        return account;
    }

    @Transactional
    public void update(Account account) {
        accountDao.update(account);
//        int i = 1/0;
        throw new RuntimeException();
    }

}
