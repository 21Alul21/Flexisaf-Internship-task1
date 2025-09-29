package com.flexisaf.bankingApp.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.flexisaf.bankingApp.Enum.AccountEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    private String accountNumber;
    
    @Enumerated(EnumType.STRING)
    private AccountEnum accountType;
    private BigDecimal balance;

    @ManyToOne()
    private UserEntity user;

}
