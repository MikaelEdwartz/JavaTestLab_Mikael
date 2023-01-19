package com.example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BankServiceImpl implements BankService {
    EmployeeRepositoryImpl employeeRepository;
    List<Employee> employees = employeeRepository.findAll();

    @Override
    public void pay(String id, double amount) {
        employees.stream()
        .filter(findEmployee(id))
        .forEach(payEmployee(amount));

    }

    private static Predicate<Employee> findEmployee(String id) {
        return e -> e.getId().equals(id);
    }

    private static Consumer<Employee> payEmployee(double amount) {
        return employee -> paySalary(amount, employee);
    }

    private static void paySalary(double amount, Employee employee) {
        employee.setSalary(amount);
        employee.setPaid(true);
    }
}
