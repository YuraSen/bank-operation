package com.senin.bank_operation.service.impl;

import com.senin.bank_operation.dto.BankAccountDTO;
import com.senin.bank_operation.entity.BankAccountEntity;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.BankAccountRepository;
import com.senin.bank_operation.service.BankAccountService;
import com.senin.bank_operation.service.util.UtilityService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private ModelMapper modelMapper;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public BankAccountDTO save(BankAccountDTO bankAccount) {
        return mapBankAccountEntityToDTO(bankAccountRepository.save(mapBankAccountDTOToEntity(bankAccount)));
    }

    @Override
    public BankAccountDTO findById(Long id) {
        UtilityService.isIdPositive(id);
        return mapBankAccountEntityToDTO(bankAccountRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT)));
    }

    @Override
    public List<BankAccountDTO> findAll() {
        return bankAccountRepository.findAll().stream().map(this::mapBankAccountEntityToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BankAccountDTO update(BankAccountDTO bankAccount) {
        return mapBankAccountEntityToDTO(entityManager.merge(mapBankAccountDTOToEntity(bankAccount)));
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        bankAccountRepository.deleteById(id);
    }

    private BankAccountDTO mapBankAccountEntityToDTO(BankAccountEntity bankAccountEntity) {
        return modelMapper.map(bankAccountEntity, BankAccountDTO.class);
    }

    private BankAccountEntity mapBankAccountDTOToEntity(BankAccountDTO bankAccountDTO) {
        return modelMapper.map(bankAccountDTO, BankAccountEntity.class);
    }

}
