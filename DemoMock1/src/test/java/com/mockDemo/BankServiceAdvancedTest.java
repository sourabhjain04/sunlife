package com.mockDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BankServiceAdvancedTest {

    @Mock
    private BankRepository repository;

    @InjectMocks
    private BankService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMultipleCallsWithDifferentResults() {
        when(repository.findAccountById(1))
            .thenReturn(new BankAccount(1, "John Doe", 1000))
            .thenReturn(new BankAccount(1, "John Doe", 2000));

        double first = service.getBalance(1);
        double second = service.getBalance(1);

        assertEquals(1000, first);
        assertEquals(2000, second);

        verify(repository, times(2)).findAccountById(1);
    }

    @Test
    void testVerifyNeverCalled() {
        when(repository.findAccountById(2)).thenReturn(null);

        try {
            service.deposit(2, 500);
        } catch (IllegalArgumentException ignored) {}

        verify(repository, never()).updateAccount(any());
    }

}
