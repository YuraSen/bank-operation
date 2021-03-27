package com.senin.bank_operation.repository;

import com.senin.bank_operation.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
