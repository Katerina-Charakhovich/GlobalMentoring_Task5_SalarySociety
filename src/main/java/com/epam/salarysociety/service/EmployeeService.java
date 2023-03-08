package com.epam.salarysociety.service;

import com.epam.salarysociety.dao.EmployeeRepository;
import com.epam.salarysociety.dao.Salary;
import com.epam.salarysociety.dto.EmployeeDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository = EmployeeRepository.getInstance();

    public List<EmployeeDto> getHiredEmployees() throws ExecutionException, InterruptedException {
        CompletableFuture<List<EmployeeDto>> employees = CompletableFuture
                .supplyAsync(this::getEmployees);
        List<EmployeeDto> listEmployee = employees.get();
        List<CompletableFuture> completableFutureSalaries = new ArrayList<>();
        for (EmployeeDto employeeDto : listEmployee
        ) {
            CompletableFuture<Salary> salary = CompletableFuture
                    .supplyAsync(() -> this.getSalary(employeeDto.getId()));
            completableFutureSalaries.add(salary);
        }
        CompletableFuture[] cfs = completableFutureSalaries.toArray(new CompletableFuture[completableFutureSalaries.size()]);
        CompletableFuture<List<Salary>> result = CompletableFuture.allOf(cfs)
                .thenApply(ignored -> completableFutureSalaries.stream()
                        .map(CompletableFuture<Salary>::join)
                        .collect(Collectors.toList())
                );
        Map<Integer, List<Salary>> salaries = result.get().stream().collect(Collectors.groupingBy(Salary::getEmployeeId));
        for (EmployeeDto employeeDto : listEmployee
        ) {
            employeeDto.setSalary(salaries.get(employeeDto.getId()).get(0).getSalary());
        }
        return listEmployee;
    }

    @Async
    public Salary getSalary(Integer id) {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return employeeRepository.getSalary(id).get();
    }

    @Async
    public List<EmployeeDto> getEmployees() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return EmployeeConverter.toListEmployeeDto(employeeRepository.getAllEmployees());
    }

}
