package com.mockDemo;

public interface BankRepository {
    BankAccount findAccountById(int accountId);
    void updateAccount(BankAccount account);
}

