package com.example.ShopeeSpring.controller;

import com.example.ShopeeSpring.dto.login.LoginRequestDto;
import com.example.ShopeeSpring.dto.login.LoginResponseDto;
import com.example.ShopeeSpring.dto.registration.UserDto;
import com.example.ShopeeSpring.entity.Account;
import com.example.ShopeeSpring.exception.ApiException;
import com.example.ShopeeSpring.service.AccountService;
import com.example.ShopeeSpring.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AccountService accountService;

    @Autowired
    SessionService sessionService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) throws ApiException {
        // kiem tra xem co nguoi dung co email va password do ko => neu co, query lay ra id thang day
        Account account = accountService.getAccountByEmailAndPassword(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        if (account == null) {
            throw new ApiException("sai tai khoan hoac mat khau");
        }
        String accountId = account.getAccountID();
        String token = UUID.randomUUID().toString();
        Boolean createSessionResult = sessionService.createSession(accountId, token);
        if (createSessionResult) {
            return new LoginResponseDto(token);
        } else {
            throw new ApiException("dang nhap that bai, vui long thu lai sau");
        }
    }

    @GetMapping("/registration")
    public String registration(@RequestBody UserDto userDto) throws ApiException {

    }
}
