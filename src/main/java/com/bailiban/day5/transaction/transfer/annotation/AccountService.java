package com.bailiban.day5.transaction.transfer.annotation;

import com.bailiban.day4.account_system.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    public void transfer(int fromId, int toId, double money) {
        Account fromAccount = accountDao.findById(fromId);
        Account toAccount = accountDao.findById(toId);
        toAccount.setMoney(toAccount.getMoney() + money);
        accountDao.update(toAccount);
        fromAccount.setMoney(fromAccount.getMoney() - money);
        accountDao.update(fromAccount);
    }
}
