package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryEmployeeRepository {
    List<Employee> employees;

    public MemoryEmployeeRepository(){
        this.employees = new ArrayList<>();
    }

    public MemoryEmployeeRepository(List<Employee> employees){
        this.employees = new ArrayList<>(employees);

    }

    public List<Employee> findAll(){
        return employees;
    }

    public void save(Employee employee){
        var tempEmployees = employees.stream()
                .filter(e -> !e.getId().equals(employee.getId()))
                .collect(Collectors.toList());
        tempEmployees.add(employee);

        employees = tempEmployees;
    }

}
