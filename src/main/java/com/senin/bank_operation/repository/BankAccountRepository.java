package com.senin.bank_operation.repository;

import com.senin.bank_operation.dto.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
