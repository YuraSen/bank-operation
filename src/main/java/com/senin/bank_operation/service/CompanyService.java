package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    Company findById(Long id);

    List<Company> findAll();

    Company update(Company company);

    void deleteById(Long id);

}
