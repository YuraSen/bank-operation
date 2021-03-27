package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.CompanyShareholdersDTO;
import com.senin.bank_operation.entity.CompanyShareholdersEntity;

import java.util.List;

public interface CompanyShareholdersService{
    CompanyShareholdersDTO save(CompanyShareholdersDTO companyShareholders);

    CompanyShareholdersDTO findById(Long id);

    List<CompanyShareholdersDTO> findAll();

    CompanyShareholdersDTO update(CompanyShareholdersDTO companyShareholders);

    void deleteById(Long id);
}
