package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.BankAccountDTO;

import java.util.List;

public interface BankAccountService {
    BankAccountDTO save(BankAccountDTO bankAccount);

    BankAccountDTO findById(Long id);

    List<BankAccountDTO> findAll();

    BankAccountDTO update(BankAccountDTO bankAccount);

    void deleteById(Long id);
}
