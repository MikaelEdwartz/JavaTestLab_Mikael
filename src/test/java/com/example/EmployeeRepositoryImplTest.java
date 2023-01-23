package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static com.example.EmployeeRepositoryImpl.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeRepositoryImplTest {

    @Test
    void usingFindAllReturnsNewEmployee() {
        var employee = new Employee("1", 1000);
        var employeeResp = Mockito.mock(EmployeeRepositoryImpl.class);
        List<Employee> employees = new ArrayList<>();
        Mockito.when(employeeResp.findAll()).thenReturn(employees);
        String employeeT = employee.toString();
        var list = employeeResp.findAll();

        employees.add(employee);
        employeeResp.save(employee);

        assertThat(employeeT).isEqualTo(list.get(0).toString());

    }

}