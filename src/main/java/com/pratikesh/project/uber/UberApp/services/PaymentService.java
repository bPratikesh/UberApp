package com.pratikesh.project.uber.UberApp.services;

import com.pratikesh.project.uber.UberApp.entities.Payment;
import com.pratikesh.project.uber.UberApp.entities.Ride;
import com.pratikesh.project.uber.UberApp.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);
    Payment createNewPayment(Ride ride);
    void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);
}
