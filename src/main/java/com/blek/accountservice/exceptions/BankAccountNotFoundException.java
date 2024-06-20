package com.blek.accountservice.exceptions;


public class BankAccountNotFoundException extends RuntimeException {

    public BankAccountNotFoundException(String message) {
        super(message);
    }
}
