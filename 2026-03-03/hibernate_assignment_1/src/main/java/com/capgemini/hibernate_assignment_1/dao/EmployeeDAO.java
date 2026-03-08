package com.capgemini.hibernate_assignment_1.dao;

import com.capgemini.hibernate_assignment_1.entity.Employee;

import javax.persistence.*;
import java.util.List;

public class EmployeeDAO
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
    public void insertEmployee(Employee emp)
    {
        EntityTransaction transaction = entityManager.getTransaction();
            
        transaction.begin();
        entityManager.persist(emp);
        transaction.commit();
    }

    public Employee getEmployeeById(int id)
    {
        Employee emp = entityManager.find(Employee.class, id);
        return emp;
    }

    public Employee getEmployeeByCode(String code)
    {
        TypedQuery<Employee> query =
        		entityManager.createQuery(
                        "SELECT e FROM Employee e WHERE e.employeeCode = :code",
                        Employee.class);

        query.setParameter("code", code);

        Employee emp = query.getSingleResult();
        return emp;
    }

    public void updateEmployeeByCode(String code, String designation, String department)
    {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        TypedQuery<Employee> query =
        		entityManager.createQuery(
                            "SELECT e FROM Employee e WHERE e.employeeCode = :code",
                            Employee.class);
        
        query.setParameter("code", code);
        
        Employee emp = query.getSingleResult();
        
        emp.setDesignation(designation);
        emp.setDepartment(department);
        entityManager.merge(emp);
        
        transaction.commit();
    }

    public void softDeleteEmployee(String code)
    {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        TypedQuery<Employee> query =
        		entityManager.createQuery(
                            "SELECT e FROM Employee e WHERE e.employeeCode = :code",
                            Employee.class);

         query.setParameter("code", code);

         Employee emp = query.getSingleResult();
         emp.setActive(false);
         entityManager.merge(emp);

         transaction.commit();
    }

    public List<Employee> getAllActiveEmployees()
    {
        TypedQuery<Employee> query =
        		entityManager.createQuery(
                        "SELECT e FROM Employee e WHERE e.active = true",
                        Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }
}