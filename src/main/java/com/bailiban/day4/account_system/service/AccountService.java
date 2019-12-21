package com.bailiban.day4.account_system.service;

import com.bailiban.day4.account_system.model.Account;

import java.util.List;

public interface AccountService {
    boolean createAccount(Account account);
    boolean deleteAccount(int id);
    void updateAccount(Account account);
    boolean saveMoney(Account account, double money);
    boolean takeMoney(Account account, double money);
    Account findById(int id);
    Account login(String name, String password);
    List<Account> list();
    boolean transfer(int fromId, int toId, double money);
}
