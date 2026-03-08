package com.assignment.dao;

import com.assignment.model.Student;
import com.assignment.util.DBUtil;

import java.sql.*;
import java.util.*;

public class StudentDAOImpl implements StudentDAO
{
    public void addStudent(Student student)
    {

        String sql = "INSERT INTO student(name, email, marks) VALUES (?, ?, ?)";

        try
        {
        	Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getMarks());

            ps.executeUpdate();
            System.out.println("Student added successfully.");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Student getStudentById(int id)
    {
        String sql = "SELECT * FROM student WHERE id=?";

        Student student = null;

        try
        {
        	Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("marks")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return student;
    }

    public List<Student> getAllStudents()
    {
        String sql = "SELECT * FROM student";

        List<Student> list = new ArrayList<>();

        try
        {
        	Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("marks")
                );

                list.add(student);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return list;
    }

    public void updateStudent(Student student)
    {
        String sql = "UPDATE student SET name=?, email=?, marks=? WHERE id=?";

        try
        {
        	Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getMarks());
            ps.setInt(4, student.getId());

            ps.executeUpdate();
            
            System.out.println("Student updated successfully.");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id)
    {
        String sql = "DELETE FROM student WHERE id=?";

        try
        {
        	Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Student deleted successfully.");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}