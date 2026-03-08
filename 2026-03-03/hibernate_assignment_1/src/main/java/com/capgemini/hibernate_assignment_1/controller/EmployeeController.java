package com.capgemini.hibernate_assignment_1.controller;

import com.capgemini.hibernate_assignment_1.dao.EmployeeDAO;
import com.capgemini.hibernate_assignment_1.entity.Employee;

import java.time.LocalDate;
import java.util.List;

public class EmployeeController
{
    public static void main(String[] args)
    {
        EmployeeDAO dao = new EmployeeDAO();

        Employee e1 = new Employee("EMP101","Rahul Sharma","rahul@gmail.com","Developer","IT",LocalDate.of(2022,3,10),true);
        Employee e2 = new Employee("EMP102","Ananya Sen","ananya@gmail.com","Tester","QA",LocalDate.of(2023,6,15),true);
        Employee e3 = new Employee("EMP103","Arjun Mehta","arjun@gmail.com","Manager","HR",LocalDate.of(2021,8,20),false);
        Employee e4 = new Employee("EMP104","Priya Kapoor","priya@gmail.com","Analyst","Finance",LocalDate.of(2024,1,5),true);

        dao.insertEmployee(e1);
        dao.insertEmployee(e2);
        dao.insertEmployee(e3);
        dao.insertEmployee(e4);

        System.out.println("Employees inserted");

        Employee emp1 = dao.getEmployeeById(1);
        System.out.println(emp1);

        Employee emp2 = dao.getEmployeeByCode("EMP102");
        System.out.println(emp2);

        dao.updateEmployeeByCode("EMP101","Senior Developer","Engineering");
        System.out.println("Employee updated");

        List<Employee> activeEmployees = dao.getAllActiveEmployees();

        System.out.println("Active Employees:");

        for(Employee e : activeEmployees)
        {
            System.out.println(e);
        }

        dao.softDeleteEmployee("EMP104");
        System.out.println("Employee soft deleted");
    }
}