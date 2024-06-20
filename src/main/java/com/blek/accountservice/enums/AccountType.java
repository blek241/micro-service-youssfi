package com.blek.accountservice.enums;

public enum AccountType {
    SAVING_ACCOUNT("SAV"), CURRENT_ACCOUNT("CUR");

    private final String value;

    private AccountType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
