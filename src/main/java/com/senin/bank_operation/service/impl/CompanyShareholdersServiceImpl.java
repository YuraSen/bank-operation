package com.senin.bank_operation.service.impl;

import com.senin.bank_operation.dto.CompanyShareholdersDTO;
import com.senin.bank_operation.entity.CompanyShareholdersEntity;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.CompanyShareholdersRepository;
import com.senin.bank_operation.service.CompanyShareholdersService;
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
public class CompanyShareholdersServiceImpl implements CompanyShareholdersService {
    @PersistenceContext
    private final EntityManager entityManager;
    private ModelMapper modelMapper;
    private final CompanyShareholdersRepository companyShareholdersRepository;

    @Override
    public CompanyShareholdersDTO save(CompanyShareholdersDTO companyShareholders) {
        return mapCompanyShareholdersEntityToDTO(companyShareholdersRepository.save(mapCompanyShareholdersDTOToEntity(companyShareholders)));
    }

    @Override
    public CompanyShareholdersDTO findById(Long id) {
        UtilityService.isIdPositive(id);
        return mapCompanyShareholdersEntityToDTO(companyShareholdersRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT)));
    }

    @Override
    public List<CompanyShareholdersDTO> findAll() {
        return companyShareholdersRepository.findAll().stream().map(this::mapCompanyShareholdersEntityToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CompanyShareholdersDTO update(CompanyShareholdersDTO companyShareholders) {
        return mapCompanyShareholdersEntityToDTO(entityManager.merge(mapCompanyShareholdersDTOToEntity(companyShareholders)));
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        companyShareholdersRepository.deleteById(id);
    }

    private CompanyShareholdersDTO mapCompanyShareholdersEntityToDTO(CompanyShareholdersEntity companyShareholdersEntity){
        return modelMapper.map(companyShareholdersEntity, CompanyShareholdersDTO.class);
    }

    private CompanyShareholdersEntity mapCompanyShareholdersDTOToEntity(CompanyShareholdersDTO companyShareholdersDTO){
        return modelMapper.map(companyShareholdersDTO, CompanyShareholdersEntity.class);
    }
}
