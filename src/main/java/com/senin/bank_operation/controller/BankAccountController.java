package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.BankAccount;
import com.senin.bank_operation.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/bankAccount")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @GetMapping("/")
    public List<BankAccount> showAll() {
        return bankAccountService.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount showById(@PathVariable("id") Long id) {
        return bankAccountService.findById(id);
    }

    @PostMapping("/")
    public BankAccount create(@RequestBody BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    @PutMapping("/{id}")
    public BankAccount edit(@RequestBody BankAccount bankAccount) {
        return bankAccountService.update(bankAccount);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        bankAccountService.deleteById(id);
    }
}
