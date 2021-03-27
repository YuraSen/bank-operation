package com.senin.bank_operation.repository;

import com.senin.bank_operation.entity.CompanyShareholdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyShareholdersRepository extends JpaRepository<CompanyShareholdersEntity, Long> {
}
