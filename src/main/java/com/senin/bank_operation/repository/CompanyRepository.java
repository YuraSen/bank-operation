package com.senin.bank_operation.repository;

import com.senin.bank_operation.dto.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
