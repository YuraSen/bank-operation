package com.senin.bank_operation.service.impl;

import com.senin.bank_operation.dto.BankAccount;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.BankAccountRepository;
import com.senin.bank_operation.service.BankAccountService;
import com.senin.bank_operation.service.UtilityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public BankAccount save(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount findById(Long id) {
        UtilityService.isIdPositive(id);
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT));
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    @Override
    @Transactional
    public BankAccount update(BankAccount bankAccount) {
        return entityManager.merge(bankAccount);
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        bankAccountRepository.deleteById(id);
    }
}
