package com.capgemini.ems_springboot_assignment.repository;

import com.capgemini.ems_springboot_assignment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}