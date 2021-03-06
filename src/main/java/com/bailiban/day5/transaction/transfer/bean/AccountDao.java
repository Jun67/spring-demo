package com.bailiban.day5.transaction.transfer.bean;

import com.bailiban.day4.account_system.dao.AccountRowMapping;
import com.bailiban.day4.account_system.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void update(Account account) throws NotEnoughMoneyException {
        if (account.getMoney() < 0) {
            throw new NotEnoughMoneyException("余额不足！");
        }
        jdbcTemplate.update("update account set money = " + account.getMoney() + " where id = " + account.getId());
    }

    public Account findById(int id) {
        return jdbcTemplate.queryForObject("select id, name, money, role from account where id = " + id, new AccountRowMapping());
    }
}
