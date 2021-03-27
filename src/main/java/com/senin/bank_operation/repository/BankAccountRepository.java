package com.senin.bank_operation.repository;

import com.senin.bank_operation.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {
    List<BankAccountEntity> findBankAccountEntitiesByBank_NameBank(String bank_nameBank);

    List<BankAccountEntity> findBankAccountEntitiesByUser_UserName(String user_userName);
}
