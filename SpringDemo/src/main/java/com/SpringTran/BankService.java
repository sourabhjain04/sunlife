package com.SpringTran;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {
    private final JdbcTemplate jdbc;

    public BankService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Transactional // Transaction starts here
    public void transferMoney(int fromId, int toId, double amount) {
        // Step 1: Deduct money from sender
        jdbc.update("UPDATE accounts SET balance = balance - ? WHERE id = ?", amount, fromId);
        System.out.println("Deducted " + amount + " from account " + fromId);

        // Step 2: Simulate an error to test rollback
        if (true) {
            throw new RuntimeException("Simulated error: transfer failed");
        }

        // Step 3: Add money to receiver
        jdbc.update("UPDATE accounts SET balance = balance + ? WHERE id = ?", amount, toId);
        System.out.println("Added " + amount + " to account " + toId);
    }
}
