package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.CompanyShareholdersDTO;
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
    public List<CompanyShareholdersDTO> showAll() {
        return companyShareholdersService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyShareholdersDTO showById(@PathVariable("id") Long id) {
        return companyShareholdersService.findById(id);
    }

    @PostMapping("/")
    public CompanyShareholdersDTO create(@RequestBody CompanyShareholdersDTO companyShareholdersDTO) {
        return companyShareholdersService.save(companyShareholdersDTO);
    }

    @PutMapping("/{id}")
    public CompanyShareholdersDTO edit(@RequestBody CompanyShareholdersDTO companyShareholdersDTO) {
        return companyShareholdersService.update(companyShareholdersDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        companyShareholdersService.deleteById(id);
    }
}