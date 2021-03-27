package com.senin.bank_operation.controller;

import com.senin.bank_operation.entity.BankAccountEntity;
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
    public List<BankAccountEntity> showAll() {
        return bankAccountService.findAll();
    }

    @GetMapping("/{id}")
    public BankAccountEntity showById(@PathVariable("id") Long id) {
        return bankAccountService.findById(id);
    }

    @PostMapping("/")
    public BankAccountEntity create(@RequestBody BankAccountEntity bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    @PutMapping("/{id}")
    public BankAccountEntity edit(@RequestBody BankAccountEntity bankAccount) {
        return bankAccountService.update(bankAccount);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        bankAccountService.deleteById(id);
    }
}
