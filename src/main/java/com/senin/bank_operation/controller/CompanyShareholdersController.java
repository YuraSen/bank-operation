package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.CompanyShareholders;
import com.senin.bank_operation.service.CompanyShareholdersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/companyShareholer")
public class CompanyShareholdersController {
    private final CompanyShareholdersService companyShareholdersService;

    @GetMapping("/")
    public List<CompanyShareholders> showAll() {
        return companyShareholdersService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyShareholders showById(@PathVariable("id") Long id) {
        return companyShareholdersService.findById(id);
    }

    @PostMapping("/")
    public CompanyShareholders create(@RequestBody CompanyShareholders companyShareholders) {
        return companyShareholdersService.save(companyShareholders);
    }

    @PutMapping("/{id}")
    public CompanyShareholders edit(@RequestBody CompanyShareholders companyShareholders) {
        return companyShareholdersService.update(companyShareholders);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        companyShareholdersService.deleteById(id);
    }
}