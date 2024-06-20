/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.blek.accountservice.repositories;

import com.blek.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blekg
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, String>{
    
}
