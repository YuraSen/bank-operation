package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.BankDTO;

import java.util.List;

public interface BankService {
    BankDTO save(BankDTO bankDTO);

    BankDTO findById(Long id);

    List<BankDTO> findAll();

    BankDTO update(BankDTO bankDTO);

    void deleteById(Long id);
}
