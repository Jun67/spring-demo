package com.bailiban.day4.account_system.dao;

import com.bailiban.day4.account_system.model.Account;

import java.util.List;

public interface AccountDao {

    boolean create(Account account);
    void update(Account account);
    void delete(int id);
    Account findById(int id);
    Account findByName(String name);
    Account accountLogin(String name, String password);
    List<Account> findAll();
}
