package com.github.kevinnowak.service;

import com.github.kevinnowak.exception.NotEnoughMoneyException;
import com.github.kevinnowak.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException("Thrown in processPayment()");
    }
}
