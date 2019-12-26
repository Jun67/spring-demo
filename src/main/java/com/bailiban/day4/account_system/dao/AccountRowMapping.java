package com.bailiban.day4.account_system.dao;

import com.bailiban.day4.account_system.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * account表字段和Account类映射关系类
 */
public class AccountRowMapping implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        double money = rs.getDouble(3);
        String role = rs.getString(4);
        return new Account(id, name, "", money, role);
    }
}