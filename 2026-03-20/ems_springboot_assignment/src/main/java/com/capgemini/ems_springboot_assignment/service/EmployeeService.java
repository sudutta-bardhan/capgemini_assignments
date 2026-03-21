package com.capgemini.ems_springboot_assignment.service;

import com.capgemini.ems_springboot_assignment.dto.EmployeeDTO;
import com.capgemini.ems_springboot_assignment.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    String saveEmployee(EmployeeDTO employeeDTO);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee updateEmployee(int id, EmployeeDTO employeeDTO);
    void deleteEmployee(int id);
}