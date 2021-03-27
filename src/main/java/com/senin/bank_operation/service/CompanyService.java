package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    CompanyDTO save(CompanyDTO company);

    CompanyDTO findById(Long id);

    List<CompanyDTO> findAll();

    CompanyDTO update(CompanyDTO company);

    void deleteById(Long id);

}
