package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.BankAccountDTO;
import com.senin.bank_operation.dto.BankDTO;
import com.senin.bank_operation.dto.UserDTO;
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
    public List<BankAccountDTO> showAll() {
        return bankAccountService.findAll();
    }

    @GetMapping("/{id}")
    public BankAccountDTO showById(@PathVariable("id") Long id) {
        return bankAccountService.findById(id);
    }

    @PostMapping("/")
    public BankAccountDTO create(@RequestBody BankAccountDTO bankAccountDTO) {
        return bankAccountService.save(bankAccountDTO);
    }

    @PutMapping("/{id}")
    public BankAccountDTO edit(@RequestBody BankAccountDTO bankAccountDTO) {
        return bankAccountService.update(bankAccountDTO);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        bankAccountService.deleteById(id);
    }

    @GetMapping("/findBanks")
    public List<BankDTO> findBankByUser(@RequestParam String userName) {
        return bankAccountService.findBankByUser(userName);
    }

    @GetMapping("/findUsers")
    public List<UserDTO> findUserByNameBank(@RequestParam String nameBank) {
        return bankAccountService.findUserByNameBank(nameBank);
    }
}
