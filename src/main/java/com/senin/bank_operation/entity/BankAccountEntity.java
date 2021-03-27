package com.senin.bank_operation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name = "name_bank_account")
    private String nameBankAccount;

    @Column(name = "balance_accout")
    private Double balanceAccount;

    @OneToOne(cascade =  CascadeType.ALL,fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "first_bank_account", referencedColumnName = "id")
    private TransactionEntity firstBankAccount;

    @OneToOne(cascade =  CascadeType.ALL,fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "second_bank_account", referencedColumnName = "id")
    private TransactionEntity secondBankAccount;

    @OneToMany
    private List<TransactionEntity> transactionEntityList;
}
