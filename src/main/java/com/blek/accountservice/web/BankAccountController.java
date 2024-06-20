/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.blek.accountservice.web;

import com.blek.accountservice.entities.BankAccount;
import com.blek.accountservice.helpers.PageElement;
import com.blek.accountservice.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author blekg
 */
@RestController
@AllArgsConstructor
@RequestMapping("bank-accounts")
public class BankAccountController {
    private BankAccountService bankAccountService;
    
    @GetMapping("")
    PageElement<BankAccount> index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return bankAccountService.findBankAccounts(page, size);
    }
    
    @GetMapping("/{accountId}")
    public BankAccount getById(@PathVariable String accountId){
        return bankAccountService.findBankAccountById(accountId);
    }

}
