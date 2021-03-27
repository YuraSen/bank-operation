package com.senin.bank_operation.service.impl;


import com.senin.bank_operation.dto.BankDTO;
import com.senin.bank_operation.dto.UserDTO;
import com.senin.bank_operation.entity.BankEntity;
import com.senin.bank_operation.entity.UserEntity;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.BankRepository;
import com.senin.bank_operation.service.BankService;
import com.senin.bank_operation.service.util.UserMapper;
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
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;
    private final UserMapper userMapper;
    private ModelMapper modelMapper;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public BankDTO save(BankDTO bankDTO) {
        return mapBankEntityToDTO(bankRepository.save(mapBankDTOToEntity(bankDTO)));
    }

    @Override
    public BankDTO findById(Long id) {
        UtilityService.isIdPositive(id);
        return mapBankEntityToDTO(bankRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT)));
    }

    @Override
    public List<BankDTO> findAll() {
        return bankRepository.findAll().stream().map(this::mapBankEntityToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BankDTO update(BankDTO bankDTO) {
        return mapBankEntityToDTO(entityManager.merge(mapBankDTOToEntity(bankDTO)));
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        bankRepository.deleteById(id);
    }

    @Override
    public List<BankDTO> findUsersByBankName(UserDTO userDTO){
        return bankRepository.findBankEntitiesByUserEntity(userMapper.mapUserDTOToEntity(userDTO)).stream().
                map(this::mapBankEntityToDTO)
                .collect(Collectors.toList());
    }

    private BankDTO mapBankEntityToDTO(BankEntity bankEntity) {
        return modelMapper.map(bankEntity, BankDTO.class);
    }

    private BankEntity mapBankDTOToEntity(BankDTO bankDTO) {
        return modelMapper.map(bankDTO, BankEntity.class);
    }

}
