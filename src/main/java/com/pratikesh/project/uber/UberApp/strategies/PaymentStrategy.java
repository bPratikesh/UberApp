package com.pratikesh.project.uber.UberApp.strategies;

import com.pratikesh.project.uber.UberApp.entities.Payment;

public interface PaymentStrategy {

    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);
}
