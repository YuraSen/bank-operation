package com.senin.bank_operation.controller;

import com.senin.bank_operation.entity.CompanyEntity;
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
    public List<CompanyEntity> showAll() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyEntity showById(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @PostMapping("/")
    public CompanyEntity create(@RequestBody CompanyEntity company) {
        return companyService.save(company);
    }

    @PutMapping("/{id}")
    public CompanyEntity edit(@RequestBody CompanyEntity company) {
        return companyService.update(company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        companyService.deleteById(id);
    }
}
