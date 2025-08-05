package com.mockDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class BankServiceTest {

    @Mock
    private BankRepository repository; // Mock dependency

    @InjectMocks
    private BankService service; // Class under test

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testDeposit() {
        BankAccount mockAccount = new BankAccount(1, "John Doe", 1000);

        // Mock behavior
        when(repository.findAccountById(1)).thenReturn(mockAccount);

        double newBalance = service.deposit(1, 500);

        assertEquals(1500, newBalance);
        verify(repository, times(1)).updateAccount(mockAccount);
    }

    @Test
    void testWithdraw_Success() {
        BankAccount mockAccount = new BankAccount(1, "John Doe", 1000);

        when(repository.findAccountById(1)).thenReturn(mockAccount);

        double newBalance = service.withdraw(1, 400);

        assertEquals(600, newBalance);
        verify(repository, times(1)).updateAccount(mockAccount);
    }

    @Test
    void testWithdraw_InsufficientFunds() {
        BankAccount mockAccount = new BankAccount(1, "John Doe", 300);

        when(repository.findAccountById(1)).thenReturn(mockAccount);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.withdraw(1, 500);
        });

        assertEquals("Insufficient funds", exception.getMessage());
        verify(repository, never()).updateAccount(mockAccount);
    }

    @Test
    void testAccountNotFound() {
        when(repository.findAccountById(99)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deposit(99, 100);
        });

        assertEquals("Account not found", exception.getMessage());
    }
}
