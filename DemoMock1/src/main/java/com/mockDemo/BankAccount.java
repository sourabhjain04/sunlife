package com.mockDemo;

public class BankAccount {
    private int accountId;
    private String holderName;
    private double balance;

    public BankAccount(int accountId, String holdername, double balance){
        this.accountId = accountId;
        this.holderName = holdername;
        this.balance = balance;

    }

    public int getAccountId() {
        return accountId;
    }

    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }




}
