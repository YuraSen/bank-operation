package com.senin.bank_operation.repository;

import com.senin.bank_operation.entity.BankEntity;
import com.senin.bank_operation.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}