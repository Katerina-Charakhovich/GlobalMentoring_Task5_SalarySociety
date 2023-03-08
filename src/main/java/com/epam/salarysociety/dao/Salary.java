package com.epam.salarysociety.dao;

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
public class Salary  {
    private Integer id;
    private Integer employeeId;
    private Integer salary;
}
