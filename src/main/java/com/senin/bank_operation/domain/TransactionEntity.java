package com.senin.bank_operation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_bank_account")
    private String FirstBankAccount;

    @Column(name = "second_bank_account")
    private String SecondBankAccount;

    @Column(name = "name_transaction")
    private String nameTransaction;
}

