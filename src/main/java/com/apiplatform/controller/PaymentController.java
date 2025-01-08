package com.apiplatform.controller;

//import com.apiplatform.service.PaymentService;

import com.apiplatform.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public String processPayment(@RequestParam double amount, @RequestParam String userId) {
        return paymentService.processPayment(amount, userId);
    }
}
