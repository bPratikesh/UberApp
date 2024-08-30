package com.pratikesh.project.uber.UberApp.services;

import com.pratikesh.project.uber.UberApp.dto.WalletTransactionDTO;
import com.pratikesh.project.uber.UberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
