package com.capgemini.ems_springboot_assignment.controller;

import com.capgemini.ems_springboot_assignment.dto.EmployeeDTO;
import com.capgemini.ems_springboot_assignment.entity.Employee;
import com.capgemini.ems_springboot_assignment.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeService service;

    @PostMapping("/save-employee")
    public String saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO)
    {
        return service.saveEmployee(employeeDTO);
    }

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id)
    {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id,
                                   @Valid @RequestBody EmployeeDTO dto)
    {
        return service.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}