package com.pruebaTecnica.demo.employee.service;

import com.pruebaTecnica.demo.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {


    List<Employee> getAllEmployees();


    Employee getEmployeeById(Long id);


    double calculateAnnualSalary(Employee employee);


}
