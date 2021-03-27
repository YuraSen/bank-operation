package com.senin.bank_operation.controller;

import com.senin.bank_operation.entity.CompanyShareholdersEntity;
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
    public List<CompanyShareholdersEntity> showAll() {
        return companyShareholdersService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyShareholdersEntity showById(@PathVariable("id") Long id) {
        return companyShareholdersService.findById(id);
    }

    @PostMapping("/")
    public CompanyShareholdersEntity create(@RequestBody CompanyShareholdersEntity companyShareholders) {
        return companyShareholdersService.save(companyShareholders);
    }

    @PutMapping("/{id}")
    public CompanyShareholdersEntity edit(@RequestBody CompanyShareholdersEntity companyShareholders) {
        return companyShareholdersService.update(companyShareholders);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        companyShareholdersService.deleteById(id);
    }
}