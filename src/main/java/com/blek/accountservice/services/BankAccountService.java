/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.blek.accountservice.services;

import com.blek.accountservice.entities.BankAccount;
import com.blek.accountservice.helpers.PageElement;

/**
 *
 * @author blekg
 */
public interface BankAccountService {

    public BankAccount findBankAccountById(String accountId);
    public BankAccount addNewBankAccount(BankAccount bankAccount);

    PageElement<BankAccount> findBankAccounts(int page, int size);
}
