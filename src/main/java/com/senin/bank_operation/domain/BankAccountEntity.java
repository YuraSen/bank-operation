package com.senin.bank_operation.domain;

import com.senin.bank_operation.dto.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "bank_account")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "balance_accout")
    private Double balanceAccount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccountEntity")
    private List<TransactionEntity> transactionEntities;
}
