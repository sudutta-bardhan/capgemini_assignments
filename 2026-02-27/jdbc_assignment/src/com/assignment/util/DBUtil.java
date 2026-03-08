package com.assignment.util;

import java.sql.*;

public class DBUtil
{
    private static final String URL = "jdbc:postgresql://localhost:5432/assignmentdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Sudutta#2026";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args)
    {
        try
        {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            Statement statement = connection.createStatement();

            String query = "CREATE TABLE student (id SERIAL PRIMARY KEY, name VARCHAR(20), email VARCHAR(30), marks INT)";

            boolean executed = statement.execute(query);

            if(!executed)
            {
                System.out.println(statement.getUpdateCount());
            }

            connection.close();

            System.out.println("Student table created successfully.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}