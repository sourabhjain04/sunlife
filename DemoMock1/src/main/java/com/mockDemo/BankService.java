package com.mockDemo;

public class BankService {

    private final BankRepository repository;

    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    public double deposit(int accountId, double amount) {
        BankAccount account = repository.findAccountById(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        account.setBalance(account.getBalance() + amount);
        repository.updateAccount(account);
        return account.getBalance();
    }

    public double withdraw(int accountId, double amount) {
        BankAccount account = repository.findAccountById(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        repository.updateAccount(account);
        return account.getBalance();
    }

    public double getBalance(int accountId) {
        BankAccount account = repository.findAccountById(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        return account.getBalance();
    }

}
