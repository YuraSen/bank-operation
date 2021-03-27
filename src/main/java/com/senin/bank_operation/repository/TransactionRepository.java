package com.senin.bank_operation.repository;

import com.senin.bank_operation.dto.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
