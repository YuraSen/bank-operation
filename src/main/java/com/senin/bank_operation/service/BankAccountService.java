package com.senin.bank_operation.service;

import com.senin.bank_operation.entity.BankAccountEntity;

import java.util.List;

public interface BankAccountService {
    BankAccountEntity save(BankAccountEntity bankAccount);

    BankAccountEntity findById(Long id);

    List<BankAccountEntity> findAll();

    BankAccountEntity update(BankAccountEntity bankAccount);

    void deleteById(Long id);
}
