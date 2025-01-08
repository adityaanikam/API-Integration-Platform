package com.apiplatform.Service;

//package com.apiplatform.assignment.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String processPayment(double amount, String userId) {
        // Simulate payment processing logic
        if (amount > 0) {
            return "Payment of $" + amount + " by User ID: " + userId + " was successful.";
        } else {
            return "Payment failed. Amount must be greater than zero.";
        }
    }
}

