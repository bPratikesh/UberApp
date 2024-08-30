package com.pratikesh.project.uber.UberApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletDTO {

    private Long id;
    private UserDTO user;
    private Double balance;
    private List<WalletTransactionDTO> transactions;

}
