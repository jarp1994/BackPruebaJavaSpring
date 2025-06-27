package com.pruebaTecnica.demo.employee.entity;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeResponse {

    private String status;

    private List<Employee> data;

}
