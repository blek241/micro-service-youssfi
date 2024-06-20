/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.blek.accountservice.services;

import com.blek.accountservice.clients.CustomerServiceRestClient;
import com.blek.accountservice.entities.BankAccount;
import com.blek.accountservice.exceptions.BankAccountNotFoundException;
import com.blek.accountservice.helpers.PageElement;
import com.blek.accountservice.repositories.BankAccountRepository;
import com.blek.models.CustomerDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author blekg
 */
@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImp implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private CustomerServiceRestClient customerServiceRestClient;

    @Override
    public BankAccount findBankAccountById(String accountId) {
        BankAccount account = bankAccountRepository.findById(accountId).orElseThrow(() -> new BankAccountNotFoundException(
                "Account with id " + accountId + " not found"
        ));

        CustomerDTO customer = customerServiceRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);

        return account;
    }

    @Override
    public BankAccount addNewBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public PageElement<BankAccount> findBankAccounts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BankAccount> customers = bankAccountRepository.findAll(pageable);
        PageElement<BankAccount> p = new PageElement<BankAccount>();
        p.setElements(customers.getContent());
        p.setTotalElements(customers.getTotalElements());
        p.setTotalPages(customers.getTotalPages());
        p.setSize(size);
        p.setCurrentPage(page);

        return p;
    }
}
