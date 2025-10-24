package com.github.kevinnowak.controller;

import com.github.kevinnowak.exception.NotEnoughMoneyException;
import com.github.kevinnowak.model.ErrorDetails;
import com.github.kevinnowak.model.PaymentDetails;
import com.github.kevinnowak.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment() {
        PaymentDetails paymentDetails = paymentService.processPayment();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }
}
