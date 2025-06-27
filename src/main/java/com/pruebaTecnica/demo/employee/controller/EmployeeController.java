package com.pruebaTecnica.demo.employee.controller;

import com.pruebaTecnica.demo.employee.entity.Employee;
import com.pruebaTecnica.demo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/lista")
    public ResponseEntity<?> getAllEmployees(){
        Map<String, Object> response = new HashMap<>();

        List<Employee> employees = employeeService.getAllEmployees();
        List<Double> anualSalaries = new ArrayList<>();
        employees.forEach(employee -> {
           Double anualSalary = employeeService.calculateAnnualSalary(employee);
           anualSalaries.add(anualSalary);
        });

       response.put("employees", employees);
       response.put("anualSalary", anualSalaries);
       return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        Employee employee = employeeService.getEmployeeById(id);
        Double salary = employeeService.calculateAnnualSalary(employee);

        response.put("employee", employee);
        response.put("anualSalary",salary);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
