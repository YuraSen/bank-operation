package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.BankDTO;
import com.senin.bank_operation.dto.UserDTO;
import com.senin.bank_operation.entity.BankEntity;
import com.senin.bank_operation.entity.UserEntity;

import java.util.List;

public interface BankService {
    BankDTO save(BankDTO bankDTO);

    BankDTO findById(Long id);

    List<BankDTO> findAll();

    BankDTO update(BankDTO bankDTO);

    void deleteById(Long id);

    List<BankDTO> findUsersByBankName(UserDTO userDTO);
}
