package com.AOPExample;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public void processPayment() {
        System.out.println("Processing payment...");
    }
}
