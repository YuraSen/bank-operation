package com.senin.bank_operation.service;


import com.senin.bank_operation.dto.TransactionDTO;
import com.senin.bank_operation.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {
    TransactionDTO save(TransactionDTO transaction);

    TransactionDTO findById(Long id);

    List<TransactionDTO> findAll();

    TransactionDTO update(TransactionDTO player);

    void deleteById(Long id);
}