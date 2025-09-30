/*
 * A controller to hanle the account creation
 * for only registered users
 * @author Augustine Alul
 * 
 */

package com.flexisaf.bankingApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexisaf.bankingApp.entity.AccountsEntity;
import com.flexisaf.bankingApp.service.AccountService;


@RestController
@RequestMapping("api/v1/")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("create-account/{email}")
    public ResponseEntity<?> createAccount(@RequestBody AccountsEntity accountDetails, @PathVariable String email){
        if(accountDetails != null && email != null){
            AccountsEntity createdAccount = accountService.createAccount(accountDetails, email);
           return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account details cannot be null");
    }

}
