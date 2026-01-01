package com.billing.service;
import com.billing.exception.InvalidPaymentException;

public class PaymentService {
    public void validatePayment(double amount) throws InvalidPaymentException {
        if (amount <= 0) {
            throw new InvalidPaymentException("Payment amount must be greater than zero!");
        }
    }
}
