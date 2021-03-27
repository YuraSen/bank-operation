package com.senin.bank_operation.service.mapper;

import com.senin.bank_operation.entity.CompanyEntity;
import com.senin.bank_operation.dto.Company;

import java.util.Objects;

public class CompanyMapper {

    public Company companyEntityToCompany(CompanyEntity companyEntity) {
        if (Objects.isNull(companyEntity)) {
            return null;
        }

        return Company.builder()
                .id(companyEntity.getId())
                .companyName(companyEntity.getCompanyName())
                .build();
    }

    public CompanyEntity companyToCompanyEntity(Company company) {
        if (Objects.isNull(company)) {
            return null;
        }

        return CompanyEntity.builder()
                .id(company.getId())
                .companyName(company.getCompanyName())
                .build();
    }
}
