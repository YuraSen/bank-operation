package com.senin.bank_operation.service;


import com.senin.bank_operation.dto.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction save(Transaction transaction);

    Transaction findById(Long id);

    List<Transaction> findAll();

    Transaction update(Transaction player);

    void deleteById(Long id);
}