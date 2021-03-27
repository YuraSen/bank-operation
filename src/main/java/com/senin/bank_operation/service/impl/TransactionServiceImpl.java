package com.senin.bank_operation.service.impl;

import com.senin.bank_operation.dto.TransactionDTO;
import com.senin.bank_operation.entity.TransactionEntity;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.TransactionRepository;
import com.senin.bank_operation.service.TransactionService;
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
public class TransactionServiceImpl implements TransactionService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final TransactionRepository transactionRepository;
    private ModelMapper modelMapper;

    @Override
    public TransactionDTO save(TransactionDTO transaction) {
        return mapTransactionEntityToDTO(transactionRepository.save(mapTransactionDTOToEntity(transaction)));
    }

    @Override
    public TransactionDTO findById(Long id) {
        UtilityService.isIdPositive(id);
        return mapTransactionEntityToDTO(transactionRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT)));
    }

    @Override
    public List<TransactionDTO> findAll() {
        return transactionRepository.findAll().stream().map(this::mapTransactionEntityToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TransactionDTO update(TransactionDTO transaction) {
        return mapTransactionEntityToDTO(entityManager.merge(mapTransactionDTOToEntity(transaction)));
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        transactionRepository.deleteById(id);
    }

    public TransactionDTO mapTransactionEntityToDTO(TransactionEntity transactionEntity){
        return modelMapper.map(transactionEntity, TransactionDTO.class);
    }

    public TransactionEntity mapTransactionDTOToEntity(TransactionDTO transactionDTO){
        return modelMapper.map(transactionDTO, TransactionEntity.class);
    }
}