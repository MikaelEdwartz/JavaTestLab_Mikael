package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryEmployeeRepositoryTest {
    MemoryEmployeeRepository memoryEmployeeRepository = new MemoryEmployeeRepository();

    @Test
    void saveExistingEmployeeUpdatesSalary() {

        var employeeOne = new Employee("1", 1000);

        memoryEmployeeRepository.save(employeeOne);

        assertThat(memoryEmployeeRepository.findAll().get(0).getSalary()).isEqualTo(1000.0);

    }

    @Test
    void creatingNewMemoryRepoCreatesEmptyList() {
        MemoryEmployeeRepository memoryEmployeeRepository1 = new MemoryEmployeeRepository();

        assertThat(memoryEmployeeRepository1.employees.size()).isZero();
    }

    @Test
    void CreatingNewMemoryRepoUsingExistingListDoesNotSaveReference(){
        var employeeOne = new Employee("1", 1000);
        var employeeTwo = new Employee("2", 1000);
        var employeeThree = new Employee("3", 1000);
        List<Employee> employees = new ArrayList<>();
        employees.add(employeeOne);
        employees.add(employeeTwo);
        employees.add(employeeThree);

        MemoryEmployeeRepository memoryEmployeeRepository = new MemoryEmployeeRepository(employees);

        assertThat(memoryEmployeeRepository.findAll().get(0)).isEqualTo(employees.get(0));

    }
}