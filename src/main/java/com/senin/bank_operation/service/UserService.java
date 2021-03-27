package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.User;

import java.util.List;

public interface UserService{
    User save(User user);

    User findById(Long id);

    List<User> findAll();

    User update(User user);

    void deleteById(Long id);
}
