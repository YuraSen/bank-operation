package com.senin.bank_operation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyShareholdersDTO {
    private Long id;

    private List<CompanyDTO> companyDTOList;

}