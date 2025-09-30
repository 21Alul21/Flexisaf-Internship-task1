/*
 * This module contains the TransactionsConroller 
 * 
 * It handles deposit and withdrawal operations of registered users
 * on their accounts 
 * 
 */

package com.flexisaf.bankingApp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexisaf.bankingApp.dto.RequestDTO;
import com.flexisaf.bankingApp.service.TransactionService;



@RestController
@RequestMapping("api/v1/")
public class TransactionsController {
    private final TransactionService transactionService;

    public TransactionsController(TransactionService transactionService){
        this.transactionService = transactionService;
    }
@PostMapping("make-deposit")
public ResponseEntity<?> makeDeposit(@RequestBody RequestDTO depositRequest){
    if (depositRequest != null){
         return ResponseEntity.status(HttpStatus.ACCEPTED)
         .body(transactionService.makeDeposit(depositRequest));
    }
    return ResponseEntity.badRequest().body("deposit operation failed");
 
}

@PostMapping("withdraw")
public ResponseEntity<?> withdrawal(RequestDTO withdrawalRequest){
    if (withdrawalRequest != null){
       return ResponseEntity.status(HttpStatus.ACCEPTED)
         .body(transactionService.withdrawal(withdrawalRequest));
    }

     return ResponseEntity.badRequest().body("withdrawal operation failed");

    }

}


