package com.senin.bank_operation.service.impl;


import com.senin.bank_operation.entity.CompanyEntity;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.CompanyRepository;
import com.senin.bank_operation.service.CompanyService;
import com.senin.bank_operation.service.util.UtilityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyServiceImpl implements CompanyService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;

    @Override
    public CompanyEntity save(CompanyEntity company) {
        return companyRepository.save(company);
    }

    @Override
    public CompanyEntity findById(Long id) {
        UtilityService.isIdPositive(id);
        return companyRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT));
    }

    @Override
    public List<CompanyEntity> findAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public CompanyEntity update(CompanyEntity company) {
        return entityManager.merge(company);
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        companyRepository.deleteById(id);
    }
}
