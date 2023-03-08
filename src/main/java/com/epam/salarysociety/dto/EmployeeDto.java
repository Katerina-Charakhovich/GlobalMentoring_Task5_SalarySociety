package com.epam.salarysociety.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class EmployeeDto {
    private Integer id;
    private String name;
    private String surName;
    private Integer salary;

}
