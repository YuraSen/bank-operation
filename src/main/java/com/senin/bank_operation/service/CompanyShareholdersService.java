package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.CompanyShareholders;

import java.util.List;

public interface CompanyShareholdersService{
    CompanyShareholders save(CompanyShareholders companyShareholders);

    CompanyShareholders findById(Long id);

    List<CompanyShareholders> findAll();

    CompanyShareholders update(CompanyShareholders companyShareholders);

    void deleteById(Long id);
}
