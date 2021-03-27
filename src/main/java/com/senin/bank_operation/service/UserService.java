package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.UserDTO;

import java.util.List;

public interface UserService{
    UserDTO save(UserDTO user);

    UserDTO findById(Long id);

    List<UserDTO> findAll();

    UserDTO update(UserDTO user);

    void deleteById(Long id);
}
