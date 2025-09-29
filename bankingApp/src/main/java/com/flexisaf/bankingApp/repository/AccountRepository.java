package com.flexisaf.bankingApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexisaf.bankingApp.entity.AccountsEntity;

public interface AccountRepository extends JpaRepository<AccountsEntity, UUID> {

}
