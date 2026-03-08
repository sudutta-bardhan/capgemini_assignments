package com.capgemini.hibernate_assignment_2.dao;

import javax.persistence.*;
import com.capgemini.hibernate_assignment_2.entity.Employee;
import java.util.*;

public class EmployeeDAO
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public String saveEmployee(Employee employee)
	{
		if(employee.getSalary() <= 0)
		{
			return "Salary must be greater than 0";
		}
		
		if(String.valueOf(employee.getPhone()).length() != 10)
		{
			return "Phone number must contain exactly 10 digits";
		}
		
		if(String.valueOf(employee.getAddress().getPincode()).length() != 6)
		{
			return "Pincode must contain 6 digits";
		}
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
		
		return "Employee saved successfully.";
	}
	
	public String saveAllEmployee(List<Employee> employees)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		for(Employee e : employees)
		{
			entityManager.persist(e);
		}
		
		transaction.commit();
		
		return "Employee list added successfully.";
	}
	
	public List<Employee> getAllEmployees()
	{		
		String jpqlQuery = "select x from Employee x";
		TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
		
		List<Employee> resultList = query.getResultList();
		
		return resultList;
	}
	
	public Employee getEmployeeById(int id)
	{
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	public String updateEmployeeSalary(int id,double salary)
	{
		Employee employee = entityManager.find(Employee.class,id);
		
		if(employee!=null)
		{
			if(salary <= 0)
			{
				return "Salary must be greater than 0";
			}
			
			EntityTransaction transaction = entityManager.getTransaction();
			
			transaction.begin();
			employee.setSalary(salary);
			entityManager.merge(employee);
			transaction.commit();
			
			return "Employee salary updated successfully";
		}
		
		return "Employee not found";
	}
	
	public String deleteEmployee(int id)
	{
		Employee employee = entityManager.find(Employee.class,id);
		
		if(employee!=null)
		{
			EntityTransaction transaction = entityManager.getTransaction();
			
			transaction.begin();
			entityManager.remove(employee);
			transaction.commit();
			
			return "Employee deleted successfully";
		}
		
		return "Employee not found";
	}
}