package com.flexisaf.bankingApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexisaf.bankingApp.entity.AccountsEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountsEntity, UUID> {
    AccountsEntity findByAccountNumber(Long accountNumber);
}
