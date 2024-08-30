package com.pratikesh.project.uber.UberApp.dto;

import com.pratikesh.project.uber.UberApp.entities.Ride;
import com.pratikesh.project.uber.UberApp.entities.Wallet;
import com.pratikesh.project.uber.UberApp.entities.enums.TransactionMethod;
import com.pratikesh.project.uber.UberApp.entities.enums.TransactionType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class WalletTransactionDTO {

    private Long id;
    private Double amount;
    private TransactionType transactionType;
    private TransactionMethod transactionMethod;
    private RideDTO ride;
    private String transactionId;
    private LocalDateTime timeStamp;
    private WalletDTO wallet;

}
