package com.capgemini.hibernate_assignment_2.controller;

import java.time.LocalDate;
import java.util.*;

import com.capgemini.hibernate_assignment_2.entity.Address;
import com.capgemini.hibernate_assignment_2.entity.Employee;
import com.capgemini.hibernate_assignment_2.dao.EmployeeDAO;

public class EmployeeController
{
	public static void main(String[] args)
	{
		EmployeeDAO employeeDao = new EmployeeDAO();

		Employee e1 = new Employee();
		e1.setEmployeeName("Rahul Sharma");
		e1.setEmail("rahul@gmail.com");
		e1.setPassword("123");
		e1.setGender("Male");
		e1.setSalary(20000);
		e1.setPhone(9876543210L);
		e1.setDateOfBirth(LocalDate.of(1998,5,10));
		
		Address a1 = new Address();
		a1.setStreet("MG Road");
		a1.setCity("Delhi");
		a1.setState("Delhi");
		a1.setCountry("India");
		a1.setPincode(110001);
		
		e1.setAddress(a1);
		a1.setEmployee(e1);
		
		System.out.println(employeeDao.saveEmployee(e1));
		

		Employee e2 = new Employee();
		e2.setEmployeeName("Ananya Das");
		e2.setEmail("ananya@gmail.com");
		e2.setPassword("abc");
		e2.setGender("Female");
		e2.setSalary(25000);
		e2.setPhone(9876501234L);
		e2.setDateOfBirth(LocalDate.of(1997,3,20));
		
		Address a2 = new Address();
		a2.setStreet("Park Street");
		a2.setCity("Kolkata");
		a2.setState("West Bengal");
		a2.setCountry("India");
		a2.setPincode(700016);
		
		e2.setAddress(a2);
		a2.setEmployee(e2);
		
		System.out.println(employeeDao.saveEmployee(e2));
		

		Employee e3 = new Employee();
		e3.setEmployeeName("Amit Singh");
		e3.setEmail("amit@gmail.com");
		e3.setPassword("xyz");
		e3.setGender("Male");
		e3.setSalary(18000);
		e3.setPhone(9999999999L);
		e3.setDateOfBirth(LocalDate.of(1996,8,15));
		
		Address a3 = new Address();
		a3.setStreet("Brigade Road");
		a3.setCity("Bangalore");
		a3.setState("Karnataka");
		a3.setCountry("India");
		a3.setPincode(560001);
		
		e3.setAddress(a3);
		a3.setEmployee(e3);
		
		System.out.println(employeeDao.saveEmployee(e3));
		

		List<Employee> employees = employeeDao.getAllEmployees();
		
		for(Employee e : employees)
		{
			System.out.println(e);
			System.out.println(e.getAddress());
		}
		
		employeeDao.updateEmployeeSalary(1,30000);

		employeeDao.deleteEmployee(3);
	}
}