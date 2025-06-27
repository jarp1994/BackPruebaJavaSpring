package com.pruebaTecnica.demo.controller;

import com.pruebaTecnica.demo.employee.controller.EmployeeController;
import com.pruebaTecnica.demo.employee.entity.Employee;
import com.pruebaTecnica.demo.employee.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeTestController {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService employeeService;

    @Test
    @DisplayName("Obtener el empleado por su id")
    public void getEmployeeById() throws Exception {

        Long id = 1L;
        Employee mockEmployee = new Employee();
        mockEmployee.setId(id);
        mockEmployee.setEmployee_name("Juan Pérez");
        mockEmployee.setEmployee_salary(3000.0);

        when(employeeService.getEmployeeById(id)).thenReturn(mockEmployee);
        when(employeeService.calculateAnnualSalary(mockEmployee)).thenReturn(36000.0);

        mockMvc.perform(get("/employees/employee/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee.id").value(id))
                .andExpect(jsonPath("$.employee.employee_name").value("Juan Pérez"))
                .andExpect(jsonPath("$.employee.employee_salary").value(3000.0));
    }
}
