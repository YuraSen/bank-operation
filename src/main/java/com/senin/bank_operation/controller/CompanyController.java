package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.Company;
import com.senin.bank_operation.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/")
    public List<Company> showAll() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public Company showById(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @PostMapping("/")
    public Company create(@RequestBody Company company) {
        return companyService.save(company);
    }

    @PutMapping("/{id}")
    public Company edit(@RequestBody Company company) {
        return companyService.update(company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        companyService.deleteById(id);
    }
}
