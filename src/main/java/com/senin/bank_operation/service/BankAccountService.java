package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccount save(BankAccount bankAccount);

    BankAccount findById(Long id);

    List<BankAccount> findAll();

    BankAccount update(BankAccount bankAccount);

    void deleteById(Long id);
}
