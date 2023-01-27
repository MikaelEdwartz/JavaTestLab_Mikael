package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryEmployeeRepositoryTest {
    MemoryEmployeeRepository memoryEmployeeRepository = new MemoryEmployeeRepository(List.of(new Employee("1", 100)));

    @Test
    void saveExistingEmployeeUpdatesSalary() {

        var employeeOne = new Employee("1", 1000);

        memoryEmployeeRepository.save(employeeOne);

        assertThat(memoryEmployeeRepository.findAll().get(0).getSalary()).isEqualTo(1000.0);

    }

    @Test
    void creatingNewMemoryRepoCreatesEmptyList() {
        MemoryEmployeeRepository memoryEmployeeRepository1 = new MemoryEmployeeRepository();

        assertThat(memoryEmployeeRepository1.employees.size()).isEqualTo(0);
    }
}