package com.flexisaf.bankingApp.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.flexisaf.bankingApp.entity.AccountsEntity;
import com.flexisaf.bankingApp.entity.UserEntity;
import com.flexisaf.bankingApp.repository.AccountRepository;
import com.flexisaf.bankingApp.repository.UserRepository;

/*
 * A service to handle the account creation
 * for only registered users
 * @author Augustine Alul
 * 
 */

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;


    public AccountService( UserRepository userRepository, AccountRepository accountRepository) {
       this.accountRepository = accountRepository;
       this.userRepository = userRepository;
    }

    public AccountsEntity createAccount(AccountsEntity accountDetails, String email){
        AccountsEntity account = accountRepository.findByAccountNumber(accountDetails.getAccountNumber());
        
        UserEntity user = userRepository.findByEmail(email);

       if (account == null && user != null) {
            accountDetails.setUser(user);
            accountDetails.setCreatedAt(LocalDateTime.now());
            return accountRepository.save(accountDetails);
        } else {
            throw new IllegalArgumentException("Account number already exist or email does not exist");
        }
    }
}
