package com.bailiban.day5.transaction.transfer.bean;

import com.bailiban.day4.account_system.model.Account;

public class AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(int fromId, int toId, double money) {
        Account fromAccount = accountDao.findById(fromId);
        Account toAccount = accountDao.findById(toId);
        toAccount.setMoney(toAccount.getMoney() + money);
        accountDao.update(toAccount);
        fromAccount.setMoney(fromAccount.getMoney() - money);
        accountDao.update(fromAccount);
    }
}
