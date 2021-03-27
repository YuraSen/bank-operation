package com.senin.bank_operation.service.mapper;

import com.senin.bank_operation.entity.CompanyEntity;
import com.senin.bank_operation.entity.CompanyShareholdersEntity;
import com.senin.bank_operation.dto.Company;
import com.senin.bank_operation.dto.CompanyShareholders;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompanyShareholdersMapper {
    private CompanyMapper companyMapper;

    public CompanyShareholders companyShareholders(CompanyShareholdersEntity companyShareholdersEntity) {
        if (Objects.isNull(companyShareholdersEntity)) {
            return null;
        }
        List<Company> companyList = companyShareholdersEntity.getCompanyEntityList().stream()
                .map(companyEntity -> companyMapper.companyEntityToCompany(companyEntity))
                .collect(Collectors.toList());

        return CompanyShareholders.builder()
                .id(companyShareholdersEntity.getId())
                .companyList(companyList)
                .build();
    }

    public CompanyShareholdersEntity companyShareholdersEntity(CompanyShareholders companyShareholders) {
        if (Objects.isNull(companyShareholders)) {
            return null;
        }

        List<CompanyEntity> companyEntityList = companyShareholders.getCompanyList().stream()
                .map(company -> companyMapper.companyToCompanyEntity(company))
                .collect(Collectors.toList());

        return CompanyShareholdersEntity.builder()
                .id(companyShareholders.getId())
                .companyEntityList(companyEntityList)
                .build();
    }
}
