package com.pruebaTecnica.demo.employee.entity;

import lombok.Data;


@Data
public class Employee {

    private Long id;

    private String employee_name;

    private double employee_salary;

    private int employee_age;

    private String profile_image;

}
