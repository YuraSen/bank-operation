package com.senin.bank_operation.service.impl;

import com.senin.bank_operation.entity.CompanyShareholdersEntity;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.CompanyShareholdersRepository;
import com.senin.bank_operation.service.CompanyShareholdersService;
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
public class CompanyShareholdersServiceImpl implements CompanyShareholdersService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final CompanyShareholdersRepository companyShareholdersRepository;

    @Override
    public CompanyShareholdersEntity save(CompanyShareholdersEntity companyShareholders) {
        return companyShareholdersRepository.save(companyShareholders);
    }

    @Override
    public CompanyShareholdersEntity findById(Long id) {
        UtilityService.isIdPositive(id);
        return companyShareholdersRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT));
    }

    @Override
    public List<CompanyShareholdersEntity> findAll() {
        return companyShareholdersRepository.findAll();
    }

    @Override
    @Transactional
    public CompanyShareholdersEntity update(CompanyShareholdersEntity companyShareholders) {
        return entityManager.merge(companyShareholders);
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        companyShareholdersRepository.deleteById(id);
    }
}
