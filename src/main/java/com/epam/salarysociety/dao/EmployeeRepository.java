package com.epam.salarysociety.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class EmployeeRepository {
    private List<Employee> employeeList = new ArrayList<>();
    private List<Salary> salaries = new ArrayList<>();
    private static EmployeeRepository instance = null;

    private EmployeeRepository() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee(i, "Name" + i, "Surname" + i);
            Salary salary = new Salary(i, i, r.nextInt(10000));
            employeeList.add(employee);
            salaries.add(salary);
        }
    }

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;

    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Optional<Salary> getSalary(int id) {
        return salaries.stream().filter(s->s.getEmployeeId()==id).findFirst();
    }
}


