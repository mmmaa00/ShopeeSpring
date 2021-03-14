package com.example.ShopeeSpring.service;

import com.example.ShopeeSpring.entity.Account;
import com.example.ShopeeSpring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account findById(String accountID) {
        try{
            return accountRepository.findById(accountID);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Account> getAll() {
        try{
            return accountRepository.getAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Integer updateById(Account account) {
        try{
            return accountRepository.updateById(account);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Integer addAccount(Account account) {
        try{
            return accountRepository.addAccount(account);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Account getAccountByEmailAndPassword(String email, String password) {
        try{
            return accountRepository.getAccountByEmailAndPassword(email, password);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Account getAccountById(String accountID) {
        try{
            return accountRepository.getAccountById(accountID);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
