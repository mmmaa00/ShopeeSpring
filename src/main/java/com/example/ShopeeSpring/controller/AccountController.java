package com.example.ShopeeSpring.controller;
import com.example.ShopeeSpring.entity.Account;
import com.example.ShopeeSpring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/find-by-id")
    public Account getById(@RequestParam String accountID) {
        return accountService.findById(accountID);
    }

    @GetMapping("/get-all-account")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PutMapping("/update-by-id")
    public Integer updateById(@RequestBody Account account) {
        return accountService.updateById(account);
    }

    @PostMapping("/add-account")
    public Integer addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }
}
