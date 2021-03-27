package com.senin.bank_operation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountDTO {
    private Long id;

    private String nameBankAccount;

    private Double balanceAccount;

    private TransactionDTO firstBankAccount;

    private TransactionDTO secondBankAccount;

    private BankDTO bank;

    private UserDTO user;

    private List<TransactionDTO> transactionDTOList;
}
