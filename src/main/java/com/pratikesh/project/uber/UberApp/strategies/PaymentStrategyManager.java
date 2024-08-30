package com.pratikesh.project.uber.UberApp.strategies;

import com.pratikesh.project.uber.UberApp.entities.enums.PaymentMethod;
import com.pratikesh.project.uber.UberApp.strategies.implementations.CashPaymentStrategy;
import com.pratikesh.project.uber.UberApp.strategies.implementations.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){
        return switch (paymentMethod){
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }
}
