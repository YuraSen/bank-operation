package com.senin.bank_operation.service.impl;


import com.senin.bank_operation.dto.CompanyDTO;
import com.senin.bank_operation.entity.CompanyEntity;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.CompanyRepository;
import com.senin.bank_operation.service.CompanyService;
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
public class CompanyServiceImpl implements CompanyService {
    @PersistenceContext
    private final EntityManager entityManager;
    private ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    @Override
    public CompanyDTO save(CompanyDTO company) {
        return mapCompanyEntityToDTO(companyRepository.save(mapCompanyDTOToEntity(company)));
    }

    @Override
    public CompanyDTO findById(Long id) {
        UtilityService.isIdPositive(id);
        return mapCompanyEntityToDTO(companyRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT)));
    }

    @Override
    public List<CompanyDTO> findAll() {
        return companyRepository.findAll().stream().map(this::mapCompanyEntityToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CompanyDTO update(CompanyDTO company) {
        return mapCompanyEntityToDTO(entityManager.merge(mapCompanyDTOToEntity(company)));
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        companyRepository.deleteById(id);
    }

    public CompanyDTO mapCompanyEntityToDTO(CompanyEntity companyEntity) {
        return modelMapper.map(companyEntity, CompanyDTO.class);
    }

    public CompanyEntity mapCompanyDTOToEntity(CompanyDTO companyDTO) {
        return modelMapper.map(companyDTO, CompanyEntity.class);
    }
}
