package com.pratikesh.project.uber.UberApp.entities;

import com.pratikesh.project.uber.UberApp.entities.enums.TransactionMethod;
import com.pratikesh.project.uber.UberApp.entities.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class WalletTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private TransactionType transactionType;
    private TransactionMethod transactionMethod;

    @OneToOne
    private Ride ride;
    private String transactionId;
    @CreationTimestamp
    private LocalDateTime timeStamp;

    @ManyToOne
    private Wallet wallet;
}