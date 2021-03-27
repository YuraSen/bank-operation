package com.senin.bank_operation.service.util;

import com.senin.bank_operation.dto.UserDTO;
import com.senin.bank_operation.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private ModelMapper modelMapper;

    public UserDTO mapUserEntityToDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserEntity mapUserDTOToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
}
