package com.bailiban.day4.aop.aopxml.transaction;


import com.bailiban.day4.account_system.model.Account;

import java.sql.SQLException;

public class AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(int fromId, int toId, double money) throws SQLException {
        Account fromAccount = accountDao.findById(fromId);
        Account toAccount = accountDao.findById(toId);
        fromAccount.setMoney(fromAccount.getMoney() - money);
        accountDao.update(fromAccount);
//        此处可以手动抛出一个异常，此时钱被转走，但接收者并不会收到。
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
