package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryEmployeeRepository {
    List<Employee> employees;

    public MemoryEmployeeRepository(){
        this.employees = new ArrayList<>();
    }

    public MemoryEmployeeRepository(List<Employee> employees){
        employees.forEach(this::save);
    }

    public List<Employee> findAll(){
        return employees.stream().toList();
    }

    public void save(Employee employee){
        if(employees == null || employees.isEmpty()) {
            employees = new ArrayList<>();
            employees.add(employee);
        }

        var tempEmployees = employees.stream()
                .filter(e -> !e.getId().equals(employee.getId()))
                .collect(Collectors.toList());
        tempEmployees.add(employee);

        employees = tempEmployees;
    }

}
