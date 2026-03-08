package com.capgemini.hibernate_assignment_1.controller;

import com.capgemini.hibernate_assignment_1.dao.SalaryRecordDAO;
import com.capgemini.hibernate_assignment_1.entity.SalaryRecord;

import java.util.List;

public class SalaryRecordController
{
    public static void main(String[] args)
    {
        SalaryRecordDAO dao = new SalaryRecordDAO();

        SalaryRecord s1 = new SalaryRecord("EMP101",50000,5000,4000,"2025-01");
        SalaryRecord s2 = new SalaryRecord("EMP102",45000,3000,3500,"2025-01");
        SalaryRecord s3 = new SalaryRecord("EMP103",70000,8000,6000,"2025-01");
        SalaryRecord s4 = new SalaryRecord("EMP101",52000,4000,4500,"2025-02");

        dao.insertSalaryRecord(s1);
        dao.insertSalaryRecord(s2);
        dao.insertSalaryRecord(s3);
        dao.insertSalaryRecord(s4);

        System.out.println("Salary records inserted");

        SalaryRecord record = dao.getSalaryByEmployeeAndMonth("EMP101","2025-01");
        System.out.println(record);

        dao.updateSalaryRecord(1,55000,6000,5000);
        System.out.println("Salary updated");

        List<SalaryRecord> list = dao.getAllSalaryRecordsByEmployee("EMP101");

        for(SalaryRecord s : list)
        {
            System.out.println(s);
        }

        dao.deleteSalaryRecord(2);
        System.out.println("Salary record deleted");
    }
}