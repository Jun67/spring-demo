package com.bailiban.day3.account;

import java.util.List;

public interface AccountDao {
    void create(Account account);
    void delete(Account account);
    Account findById(int id);
    List<Account> findAll();
}
