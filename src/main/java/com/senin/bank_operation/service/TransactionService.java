package com.senin.bank_operation.service;


import com.senin.bank_operation.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {
    TransactionEntity save(TransactionEntity transaction);

    TransactionEntity findById(Long id);

    List<TransactionEntity> findAll();

    TransactionEntity update(TransactionEntity player);

    void deleteById(Long id);
}