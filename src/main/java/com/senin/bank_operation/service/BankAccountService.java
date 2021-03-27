package com.senin.bank_operation.service;

import com.senin.bank_operation.dto.BankAccountDTO;
import com.senin.bank_operation.dto.BankDTO;
import com.senin.bank_operation.dto.UserDTO;
import com.senin.bank_operation.entity.BankAccountEntity;
import com.senin.bank_operation.entity.BankEntity;
import com.senin.bank_operation.entity.UserEntity;

import java.util.List;

public interface BankAccountService {
    BankAccountDTO save(BankAccountDTO bankAccount);

    BankAccountDTO findById(Long id);

    List<BankAccountDTO> findAll();

    BankAccountDTO update(BankAccountDTO bankAccount);

    void deleteById(Long id);

    List<UserDTO> findUserByNameBank(String nameBank);

    List<BankDTO> findBankByUser(String userName);
}