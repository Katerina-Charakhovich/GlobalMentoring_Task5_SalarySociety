package com.epam.salarysociety.controller;

import com.epam.salarysociety.dto.EmployeeDto;
import com.epam.salarysociety.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    @ResponseBody
    public List<EmployeeDto> getHiredEmployees() throws ExecutionException, InterruptedException {
            return employeeService.getHiredEmployees();
    }
    @GetMapping(value="/")
    public @ResponseBody String status(){

        return "Service is working" ;
    }
}
