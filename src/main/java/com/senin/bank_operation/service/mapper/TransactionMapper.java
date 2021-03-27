package com.senin.bank_operation.service.mapper;

import com.senin.bank_operation.entity.TransactionEntity;
import com.senin.bank_operation.dto.Transaction;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TransactionMapper {
    public Transaction transactionEntityToTransaction(TransactionEntity transactionEntity) {
        if (Objects.isNull(transactionEntity)) {
            return null;
        }
        return Transaction.builder()
                .id(transactionEntity.getId())

                .nameTransaction(transactionEntity.getNameTransaction())
                .build();
    }

    public TransactionEntity transactionToTransactionEntity(Transaction transaction) {
        if (Objects.isNull(transaction)) {
            return null;
        }
        return TransactionEntity.builder()
                .id(transaction.getId())

                .nameTransaction(transaction.getNameTransaction())
                .build();
    }
}