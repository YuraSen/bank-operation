package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.CompanyDTO;
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
    public List<CompanyDTO> showAll() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyDTO showById(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @PostMapping("/")
    public CompanyDTO create(@RequestBody CompanyDTO companyDTO) {
        return companyService.save(companyDTO);
    }

    @PutMapping("/{id}")
    public CompanyDTO edit(@RequestBody CompanyDTO companyDTO) {
        return companyService.update(companyDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        companyService.deleteById(id);
    }
}
