package com.capgemini.hibernate_assignment_1.dao;

import com.capgemini.hibernate_assignment_1.entity.SalaryRecord;

import javax.persistence.*;
import java.util.List;

public class SalaryRecordDAO
{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void insertSalaryRecord(SalaryRecord salary)
    {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        salary.setNetSalary(
                salary.getBaseSalary()
                        + salary.getBonus()
                        - salary.getTax());

        entityManager.persist(salary);

        transaction.commit();
    }

    public void updateSalaryRecord(int id, double baseSalary, double bonus, double tax)
    {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        SalaryRecord record = entityManager.find(SalaryRecord.class, id);

        record.setBaseSalary(baseSalary);
        record.setBonus(bonus);
        record.setTax(tax);

        record.setNetSalary(baseSalary + bonus - tax);

        entityManager.merge(record);

        transaction.commit();
    }

    public void deleteSalaryRecord(int id)
    {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        SalaryRecord record =
                entityManager.find(SalaryRecord.class, id);

        entityManager.remove(record);

        transaction.commit();
    }

    public SalaryRecord getSalaryByEmployeeAndMonth(String code, String month)
    {
        TypedQuery<SalaryRecord> query =
                entityManager.createQuery(
                        "SELECT s FROM SalaryRecord s WHERE s.employeeCode = :code AND s.salaryMonth = :month",
                        SalaryRecord.class);

        query.setParameter("code", code);
        query.setParameter("month", month);

        SalaryRecord record = query.getSingleResult();

        return record;
    }

    public List<SalaryRecord> getAllSalaryRecordsByEmployee(String code)
    {
        TypedQuery<SalaryRecord> query =
                entityManager.createQuery(
                        "SELECT s FROM SalaryRecord s WHERE s.employeeCode = :code",
                        SalaryRecord.class);

        query.setParameter("code", code);

        List<SalaryRecord> records = query.getResultList();

        return records;
    }
}