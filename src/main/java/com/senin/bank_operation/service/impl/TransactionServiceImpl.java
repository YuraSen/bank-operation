package com.senin.bank_operation.service.impl;

import com.senin.bank_operation.dto.Transaction;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.TransactionRepository;
import com.senin.bank_operation.service.TransactionService;
import com.senin.bank_operation.service.UtilityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionServiceImpl implements TransactionService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction findById(Long id) {
        UtilityService.isIdPositive(id);
        return transactionRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT));
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    @Transactional
    public Transaction update(Transaction transaction) {
        return entityManager.merge(transaction);
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        transactionRepository.deleteById(id);
    }
}