package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.TransactionDTO;
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
    public List<TransactionDTO> showAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public TransactionDTO showById(@PathVariable("id") Long id) {
        return transactionService.findById(id);
    }

    @PostMapping("/")
    public TransactionDTO create(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.save(transactionDTO);
    }

    @PutMapping("/{id}")
    public TransactionDTO edit(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.update(transactionDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        transactionService.deleteById(id);
    }
}
