package com.senin.bank_operation.service.impl;


import com.senin.bank_operation.dto.UserDTO;
import com.senin.bank_operation.entity.UserEntity;
import com.senin.bank_operation.exception.IncorrectIdRuntimeException;
import com.senin.bank_operation.repository.UserRepository;
import com.senin.bank_operation.service.UserService;
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
public class UserServiceImpl implements UserService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private ModelMapper modelMapper;

    @Override
    public UserDTO save(UserDTO user) {
        return userMapper.mapUserEntityToDTO(userRepository.save(userMapper.mapUserDTOToEntity(user)));
    }

    @Override
    public UserDTO findById(Long id) {
        UtilityService.isIdPositive(id);
        return userMapper.mapUserEntityToDTO(userRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException(UtilityService.ID_CORRECT)));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::mapUserEntityToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO user) {
        return userMapper.mapUserEntityToDTO( entityManager.merge(userMapper.mapUserDTOToEntity(user)));
    }

    @Override
    public void deleteById(Long id) {
        UtilityService.isIdPositive(id);
        userRepository.deleteById(id);
    }

}
