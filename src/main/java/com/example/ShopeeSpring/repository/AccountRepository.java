package com.example.ShopeeSpring.repository;

import com.example.ShopeeSpring.entity.Account;
import com.example.ShopeeSpring.helper.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AccountRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Account findById(String accountId) {
        String sql = "select * from Account where accountID = ?;";
        Object[] params = {accountId};
        return (Account) jdbcTemplate.queryForObject(sql, new AccountMapper(), params);
    }

    public Account findByEmail(String email) {
        String sql = "select * from Account where email = ?;";
        Object[] params = {email};
        return (Account) jdbcTemplate.queryForObject(sql, new AccountMapper(), params);
    }

    public List<Account> getAll() {
        String sql = "select * from Account ;";
        List<Account> listAccount = jdbcTemplate.query(sql, new AccountMapper());
        return listAccount;
    }

    public Account getAccountByEmailAndPassword(String email, String password) {
        String sql = "select * from Account WHERE email =? AND password =? ;";
        Object[] parmas = {email, password};
        return  (Account) jdbcTemplate.queryForObject(sql, new AccountMapper(), parmas);
    }

    public Integer updateById(Account account) {
        String sql = "UPDATE Account SET " +
                " email =?," +
                " display =?," +
                " password =?," +
                " role =?," +
                " avatar =?" +
                " WHERE accountID =? ;";
        Object params[] = new Object[6];
        params[0] = account.getEmail();
        params[1] = account.getDisplay();
        params[2] = account.getPassword();
        params[3] = account.getRole();
        params[4] = account.getAvatar();
        params[5] = account.getAccountID();
        return jdbcTemplate.update(sql, params);
    }

    public Integer addAccount(Account account) {
        String sql = "INSERT INTO Account (accountID,email,display,password,role,avatar) VALUES (?,?,?,?,?,?) ;";
        Object params[] = new Object[6];
        params[0] = UUID.randomUUID().toString();
        params[1] = account.getEmail();
        params[2] = account.getDisplay();
        params[3] = account.getPassword();
        params[4] = account.getRole();
        params[5] = account.getAvatar();
        return jdbcTemplate.update(sql, params);
    }

    public Account getAccountById(String accountId) {
        String sql = "SELECT * FROM Account WHERE accountID =? ;";
        Account account = (Account) jdbcTemplate.queryForObject(sql, new AccountMapper(), new Object[]{accountId});
        return account;
    }
}
