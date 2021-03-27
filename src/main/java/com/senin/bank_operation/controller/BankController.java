package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.BankDTO;
import com.senin.bank_operation.dto.UserDTO;
import com.senin.bank_operation.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/bank")
public class BankController {
    private final BankService bankService;

    @GetMapping("/")
    public List<BankDTO> showAll() {
        return bankService.findAll();
    }

    @GetMapping("/{id}")
    public BankDTO showById(@PathVariable("id") Long id) {
        return bankService.findById(id);
    }

    @GetMapping("/findUsers/{bankName}")
    public List<UserDTO> showUsersByBankName(@PathVariable("bankName") String bankName){
        return bankService.findUsersByBankName(bankName);
    }
}