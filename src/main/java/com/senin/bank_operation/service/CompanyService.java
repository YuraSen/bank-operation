package com.senin.bank_operation.service;

import com.senin.bank_operation.entity.CompanyEntity;

import java.util.List;

public interface CompanyService {
    CompanyEntity save(CompanyEntity company);

    CompanyEntity findById(Long id);

    List<CompanyEntity> findAll();

    CompanyEntity update(CompanyEntity company);

    void deleteById(Long id);

}
