/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.blek.accountservice.entities;

import com.blek.accountservice.enums.AccountType;
import com.blek.models.CustomerDTO;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/**
 *
 * @author blekg
 */
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder 
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private Double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private long customerId;
    @Transient
    private CustomerDTO customer;
}
