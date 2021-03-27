package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.Company;
import com.senin.bank_operation.dto.Transaction;
import com.senin.bank_operation.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/")
    public List<Transaction> showAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public Transaction showById(@PathVariable("id") Long id) {
        return transactionService.findById(id);
    }

    @PostMapping("/")
    public Transaction create(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @PutMapping("/{id}")
    public Transaction edit(@RequestBody Transaction transaction) {
        return transactionService.update(transaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        transactionService.deleteById(id);
    }
}
