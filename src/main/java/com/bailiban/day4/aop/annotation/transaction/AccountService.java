package com.bailiban.day4.aop.annotation.transaction;


import com.bailiban.day4.account_system.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AccountService {


    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(int fromId, int toId, double money) throws SQLException {
        Account fromAccount = accountDao.findById(fromId);
        Account toAccount = accountDao.findById(toId);
        fromAccount.setMoney(fromAccount.getMoney() - money);
        accountDao.update(fromAccount);
//        if (true)
//            throw new RuntimeException();
        toAccount.setMoney(toAccount.getMoney() + money);
        accountDao.update(toAccount);
    }

    public void transfer2(int fromId, int toId, double money) {
        Account fromAccount = accountDao.findById(fromId);
        Account toAccount = accountDao.findById(toId);

        try {
            System.out.println("begin");
            JdbcUtil.connection.setAutoCommit(false);
            fromAccount.setMoney(fromAccount.getMoney() - money);
            accountDao.update(fromAccount);
//            if (true)
//                throw new RuntimeException();
            toAccount.setMoney(toAccount.getMoney() + money);
            accountDao.update(toAccount);
            System.out.println("commit");
            JdbcUtil.connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback");
                JdbcUtil.connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
