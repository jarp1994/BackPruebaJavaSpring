package com.pruebaTecnica.demo.employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebaTecnica.demo.employee.entity.Employee;
import com.pruebaTecnica.demo.employee.entity.EmployeeByIdResponse;
import com.pruebaTecnica.demo.employee.entity.EmployeeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String URL_BASE = "https://dummy.restapiexample.com/api/v1/employees";
    private static final String URL_EMPLOYEE_BY_ID = "https://dummy.restapiexample.com/api/v1/employee/";

    private final RestTemplate restTemplate;

    public EmployeeServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Employee> getAllEmployees(){
        EmployeeResponse response = restTemplate.getForObject(URL_BASE, EmployeeResponse.class);
        return response.getData();
    }

    @Override
    public Employee getEmployeeById(Long id){
        String urlGetEmployeeById = URL_EMPLOYEE_BY_ID + id;
        EmployeeByIdResponse response = restTemplate.getForObject(urlGetEmployeeById, EmployeeByIdResponse.class);
        return response.getData();
    }

    @Override
    public double calculateAnnualSalary(Employee employee) {
        if(employee == null) {
            return 0.0;
        }else{
            return employee.getEmployee_salary() * 12;
        }

    }

}
