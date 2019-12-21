package com.bailiban.day4.account_system.service;

import com.bailiban.day4.account_system.dao.AccountDao;
import com.bailiban.day4.account_system.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    /**
     * 创建账户
     * @return flag 是否创建成功
     */
    @Override
    public boolean createAccount(Account account) {
        if (account == null) {
            System.out.println("非法账户。");
            return false;
        }
        return accountDao.create(account);
    }

    /**
     * 更新账户信息（余额）
     */
    @Override
    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    /**
     * 存钱
     */
    @Override
    public boolean saveMoney(Account account, double money) {
        if (account == null || money < 0) {
            return false;
        }
        account.setMoney(account.getMoney() + money);
        updateAccount(account);
        return true;
    }

    /**
     * 取钱
     */
    @Override
    public boolean takeMoney(Account account, double money) {
        if (account == null || money < 0) {
            return false;
        }
        if (account.getMoney() < money) {
            System.out.println("余额不足");
            return false;
        }
        account.setMoney(account.getMoney() - money);
        updateAccount(account);
        return true;
    }

    /**
     * 根据id查找用户
     */
    @Override
    public Account findById(int id) {
        return accountDao.findById(id);
    }

    /**
     * 登录
     * @return account 成功则返回账户
     */
    @Override
    public Account login(String name, String password) {
        // 登录，并返回账户信息
        return accountDao.accountLogin(name, password);
    }

    /**
     * 删除账户
     */
    @Override
    public boolean deleteAccount(int id) {
        if (id == 1) {
            System.out.println("超级管理员账户不能删除。");
        }
        // 判断待账户是否存在
        else if (accountDao.findById(id) == null) {
            System.out.println("ID为 " + id + " 的账户不存在。");
        } else {
            System.out.println("ID为 " + id + " 的账户删除成功。");
            accountDao.delete(id);
        }
        return true;
    }

    /**
     * 查看用户列表，只有管理员才有此操作
     */
    @Override
    public List<Account> list() {
        List<Account> accountList = accountDao.findAll();
        if (accountList == null || accountList.size() == 0) {
            System.out.println("没有用户。");
        } else {
            accountList.forEach(System.out::println);
        }
        return accountList;
    }

    /**
     * 转账操作
     * @param fromId 转出账户id
     * @param toId 转入账户id
     * @param money 转账金额
     */
    @Override
    public boolean transfer(int fromId, int toId, double money) {
        Account fromAccount = findById(fromId);
        Account toAccount = findById(toId);
        if (fromAccount == null || money < 0 ||
                money > fromAccount.getMoney() || toAccount == null) {
            return false;
        }
        fromAccount.setMoney(fromAccount.getMoney() - money);
        updateAccount(fromAccount);
        toAccount.setMoney(toAccount.getMoney() + money);
        updateAccount(toAccount);
        return true;
    }
}
