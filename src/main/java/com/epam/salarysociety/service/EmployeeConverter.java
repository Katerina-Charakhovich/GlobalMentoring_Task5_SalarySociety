package com.epam.salarysociety.service;

import com.epam.salarysociety.dao.Employee;
import com.epam.salarysociety.dto.EmployeeDto;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeConverter {

    public static List<EmployeeDto> toListEmployeeDto(List<Employee> employees) {
        return employees == null || employees.isEmpty() ? null :
                employees.stream().map(EmployeeConverter::toEmployeeDto).collect(Collectors.toList());
    }

    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        if (employee.getId() != null) {
            employeeDto.setId(employee.getId());
        }
        employeeDto.setName(employee.getName());
        employeeDto.setSurName(employee.getSurName());
        return employeeDto;
    }
}
