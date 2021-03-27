package com.senin.bank_operation.service;

import com.senin.bank_operation.entity.CompanyShareholdersEntity;

import java.util.List;

public interface CompanyShareholdersService{
    CompanyShareholdersEntity save(CompanyShareholdersEntity companyShareholders);

    CompanyShareholdersEntity findById(Long id);

    List<CompanyShareholdersEntity> findAll();

    CompanyShareholdersEntity update(CompanyShareholdersEntity companyShareholders);

    void deleteById(Long id);
}
