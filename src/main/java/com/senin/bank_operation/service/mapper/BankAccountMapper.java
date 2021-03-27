package com.senin.bank_operation.service.mapper;

import com.senin.bank_operation.entity.BankAccountEntity;
import com.senin.bank_operation.entity.TransactionEntity;
import com.senin.bank_operation.dto.BankAccount;
import com.senin.bank_operation.dto.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BankAccountMapper {
    private TransactionMapper transactionMapper;

    public BankAccount bankAccountEntityToBankAccount(BankAccountEntity bankAccountEntity) {
        if (Objects.isNull(bankAccountEntity)) {
            return null;
        }
        List<Transaction> transactionList = bankAccountEntity.getTransactionEntityList().stream()
                .map(transactionEntity -> transactionMapper.transactionEntityToTransaction(transactionEntity))
                .collect(Collectors.toList());
        return BankAccount.builder()
                .id(bankAccountEntity.getId())
                .nameBankAccount(bankAccountEntity.getNameBankAccount())
                .balanceAccount(bankAccountEntity.getBalanceAccount())
                .firstBankAccount(bankAccountEntity.getFirstBankAccount())
                .secondBankAccount(bankAccountEntity.getSecondBankAccount())
                .transactionList(transactionList)
                .build();
    }

    public BankAccountEntity bankAccountToBankAccountEntity(BankAccount bankAccount) {
        if (Objects.isNull(bankAccount)) {
            return null;
        }

        List<TransactionEntity> transactionEntityList = bankAccount.getTransactionList().stream()
                .map(transaction -> transactionMapper.transactionToTransactionEntity(transaction))
                .collect(Collectors.toList());

        return BankAccountEntity.builder()
                .id(bankAccount.getId())
                .nameBankAccount(bankAccount.getNameBankAccount())
                .balanceAccount(bankAccount.getBalanceAccount())
                .firstBankAccount(bankAccount.getFirstBankAccount())
                .secondBankAccount(bankAccount.getSecondBankAccount())
                .transactionEntityList(transactionEntityList)
                .build();
    }

}
