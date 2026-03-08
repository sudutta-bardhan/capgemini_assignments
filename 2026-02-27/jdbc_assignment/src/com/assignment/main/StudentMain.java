package com.assignment.main;

import com.assignment.dao.StudentDAO;
import com.assignment.dao.StudentDAOImpl;
import com.assignment.model.Student;

import java.util.List;

public class StudentMain
{
    public static void main(String[] args)
    {
        StudentDAO dao = new StudentDAOImpl();

        Student s1 = new Student("Sudutta Bardhan", "suduttabardhan07@gmail.com", 85);
        dao.addStudent(s1);

        Student student1 = dao.getStudentById(1);
        System.out.println(student1.getName());
        
        Student s2 = new Student("Sulagna Ghosh", "sulagnaghosh17@gmail.com", 78);
        dao.addStudent(s2);

        Student student2 = dao.getStudentById(2);
        System.out.println(student2.getName());

        List<Student> students = dao.getAllStudents();

        System.out.println("\nAll Students: ");
        for (Student s : students)
        {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getEmail() + " " + s.getMarks());
        }

        Student updateStudent = new Student(1, "Sudutta Bardhan", "suduttabardhan07@gmail.com", 94);
        dao.updateStudent(updateStudent);

        dao.deleteStudent(2);
    }
}