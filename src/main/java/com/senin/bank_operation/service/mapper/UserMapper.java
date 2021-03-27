package com.senin.bank_operation.service.mapper;

import com.senin.bank_operation.entity.BankAccountEntity;
import com.senin.bank_operation.entity.UserEntity;
import com.senin.bank_operation.dto.BankAccount;
import com.senin.bank_operation.dto.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private BankAccountMapper bankAccountMapper;

    public User userEntityToUser(UserEntity userEntity) {
        if (Objects.isNull(userEntity)) {
            return null;

        }
        List<BankAccount> bankAccountList = userEntity.getBankAccountEntityList().stream()
                .map(bankAccountEntity -> bankAccountMapper.bankAccountEntityToBankAccount(bankAccountEntity))
                .collect(Collectors.toList());
        return User.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .bankAccountList(bankAccountList)
                .build();
    }

    public UserEntity userToUserEntity(User user) {
        if (Objects.isNull(user)) {
            return null;
        }
        List<BankAccountEntity> bankAccountEntityList = user.getBankAccountList().stream()
                .map(bankAccount -> bankAccountMapper.bankAccountToBankAccountEntity(bankAccount))
                .collect(Collectors.toList());

        return UserEntity.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .bankAccountEntityList(bankAccountEntityList)
                .build();
    }
}
