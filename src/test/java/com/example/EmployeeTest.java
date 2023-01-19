package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    static double INITIAL_SALARY = 1000;
    Employee testEmployee = new Employee("test", INITIAL_SALARY);


    @Test
    void callingGetIDReturnsCorrectID() {

        var ID = testEmployee.getId();

        assertThat(ID).isEqualTo("test");
    }

    @Test
    void callingSetIDMethodChangesCurrentID() {
        var newID = "NewTestID";

        testEmployee.setId(newID);

        assertThat(testEmployee.getId()).isEqualTo(newID);
    }

    @Test
    void CallingGetSalaryMethodReturnsCorrectNumber() {

        assertThat(testEmployee.getSalary()).isEqualTo(INITIAL_SALARY);

    }

    @Test
    void changingSalaryChangesNumber() {
        var newSalary = INITIAL_SALARY*3;

        testEmployee.setSalary(newSalary);

        assertThat(testEmployee.getSalary()).isEqualTo(newSalary);

    }

    @Test
    void creatingEmployeeShouldBeCreatedWithFalsePaid() {

        assertThat(testEmployee.isPaid()).isFalse();


    }

    @Test
    void payingEmployeeChangesStatusToPaid() {

        testEmployee.setPaid(true);

        assertThat(testEmployee.isPaid()).isTrue();

    }

    @Test
    void testToString() {
        var actualString = "Employee [id=test, salary=1000.0]";

        assertThat(testEmployee.toString()).isEqualTo(actualString);


    }
}