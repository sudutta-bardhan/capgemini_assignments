package com.capgemini.ems_springboot_assignment.service;

import com.capgemini.ems_springboot_assignment.dto.AddressDTO;
import com.capgemini.ems_springboot_assignment.dto.EmployeeDTO;
import com.capgemini.ems_springboot_assignment.entity.Address;
import com.capgemini.ems_springboot_assignment.entity.Employee;
import com.capgemini.ems_springboot_assignment.exception.EmployeeNotFoundException;
import com.capgemini.ems_springboot_assignment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String saveEmployee(EmployeeDTO employeeDTO)
    {
        Employee employee = Employee.builder()
                .name(employeeDTO.getName())
                .email(employeeDTO.getEmail())
                .phone(employeeDTO.getPhone())
                .gender(employeeDTO.getGender())
                .designation(employeeDTO.getDesignation())
                .salary(employeeDTO.getSalary())
                .dateOfJoining(employeeDTO.getDateOfJoining())
                .build();

        AddressDTO addressDTO = employeeDTO.getAddress();

        Address address = new Address();
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setPincode(addressDTO.getPincode());

        employee.setAddress(address);

        int id = employeeRepository.save(employee).getId();

        return "Employee saved successfully with id " + id;
    }

    @Override
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id)
    {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(int id, EmployeeDTO dto)
    {
        Employee existing = getEmployeeById(id);

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setGender(dto.getGender());
        existing.setDesignation(dto.getDesignation());
        existing.setSalary(dto.getSalary());
        existing.setDateOfJoining(dto.getDateOfJoining());

        Address address = existing.getAddress();
        AddressDTO addressDTO = dto.getAddress();

        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setPincode(addressDTO.getPincode());

        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(int id)
    {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}