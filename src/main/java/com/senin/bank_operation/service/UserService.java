package com.senin.bank_operation.service;

import com.senin.bank_operation.entity.UserEntity;

import java.util.List;

public interface UserService{
    UserEntity save(UserEntity user);

    UserEntity findById(Long id);

    List<UserEntity> findAll();

    UserEntity update(UserEntity user);

    void deleteById(Long id);
}
