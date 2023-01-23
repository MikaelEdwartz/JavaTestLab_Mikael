package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class EmployeesTest {
    BankService bankService = Mockito.mock(BankService.class);
    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();

    @Test
    void callingPayEmployeesOnTwoExistingEmployeesIncrementsPaymentsVariableWithTwo() {
        var employees = new Employees(employeeRepository, bankService);
        var employeeOne = new Employee("1", 1000);
        var employeeTwo = new Employee("2", 1000);

        employeeRepository.save(employeeOne);
        employeeRepository.save(employeeTwo);

        assertThat(employees.payEmployees()).isEqualTo(2);

    }
    @Test
    void checkThatPayEmployeesReturnsCorrectAmountOfPayments(){
        var employees = new Employees(employeeRepository, bankService);
        var employeeOne = new Employee("1", 1000);
        var employeeTwo = new Employee("2", 1000);

        employeeRepository.save(employeeOne);
        employeeRepository.save(employeeTwo);

        assertThat(employees.payEmployees()).isNotEqualTo(1);

    }

    @Test
    void gettingRunTimeExceptionSetsEmployeePaidToNull() {
        var employeeOne = new Employee("1", 1000);
        employeeRepository.save(employeeOne);
        Employees employees = new Employees(employeeRepository, bankService);
        employeeOne.setPaid(true);

        doThrow(new RuntimeException()).when(bankService).pay(employeeOne.getId(), employeeOne.getSalary());
        employees.payEmployees();

        assertThat(employeeOne.isPaid()).isFalse();

    }

}


    
    
