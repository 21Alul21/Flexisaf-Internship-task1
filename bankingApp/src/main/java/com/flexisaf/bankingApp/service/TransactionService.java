package com.flexisaf.bankingApp.service;

import org.springframework.stereotype.Service;


import com.flexisaf.bankingApp.dto.RequestDTO;
import com.flexisaf.bankingApp.entity.AccountsEntity;
import com.flexisaf.bankingApp.repository.AccountRepository;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;

    public TransactionService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;

    }
 
    // deposit method
    public AccountsEntity makeDeposit(RequestDTO depositRequest){
        if(depositRequest.getAmount().longValue() < 0){
            throw new IllegalArgumentException("deposit amount must be greater than zero");
        }

        // get account entity using account number
        AccountsEntity accountEntity = accountRepository
        .findByAccountNumber(depositRequest.getAccountNumber());
        
        if (accountEntity != null){
            accountEntity.setBalance(depositRequest.getAmount().add(accountEntity.getBalance()));
            accountRepository.save(accountEntity);
        }
        return accountEntity;
    }


    // Withdral method
    public AccountsEntity withdrawal(RequestDTO withdrawalRequest) {
        AccountsEntity account = accountRepository
        .findByAccountNumber(withdrawalRequest.getAccountNumber());
        if (withdrawalRequest.getAmount().compareTo(account.getBalance()) == 1){
                throw new IllegalArgumentException("withdrawal amount cannot be higher than account balance");
        }
        
        account.setBalance(account.getBalance().subtract(withdrawalRequest.getAmount()));
        accountRepository.save(account);
        return account;
    }
}
