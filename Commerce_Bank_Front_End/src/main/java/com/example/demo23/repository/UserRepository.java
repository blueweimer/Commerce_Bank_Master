package com.example.demo23.repository;

import java.sql.*;

public class UserRepository {

    Statement statement;

    public UserRepository() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        // Connect to a database
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/javabook" , "root", "root");
        System.out.println("Database connected");

        // Create a statement
        statement = connection.createStatement();
    }

    public String findbyLastName(String lastName) throws SQLException {

        ResultSet resultSet = statement.executeQuery("select firstName, mi, lastName from Student " +
                "where lastName = '"+lastName+"'");
        //5. Iterate through the result and print the student names using while loop

        String output="";


        while(resultSet.next())
        {
            //System.out.println(resultSet.getString(1) + "\t" +resultSet.getString(2) + "\t" + resultSet.getString(3));
            String firstName = resultSet.getString("firstName");
            String midName = resultSet.getString("mi");
            String lName = resultSet.getString("lastName");
            System.out.println(firstName+"\t"+midName+"\t"+ lName);

            output+=firstName+" "+midName+" "+lName+"<br>";

        }

        return output;

    }

    public String findbyLast_SSn(String lastName, String ssn) throws SQLException {
        ////
        ResultSet resultSet = statement.executeQuery("select firstName, mi, lastName from Student " +
                "where lastName = '"+lastName+"'"+" and ssn = '"+ssn+"'");

        String output="";
        while(resultSet.next())
        {
            //System.out.println(resultSet.getString(1) + "\t" +resultSet.getString(2) + "\t" + resultSet.getString(3));
            String firstName = resultSet.getString("firstName");
            String midName = resultSet.getString("mi");
            String lName = resultSet.getString("lastName");
            System.out.println(firstName+"\t"+midName+"\t"+ lName);

            output+=firstName+" "+midName+" "+lName+"<br>";

        }
        return output;
    }

    public boolean findbyLast_Pwd(String lastName, String password) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select id, password, username from user " +
                "where username = '"+lastName+"'"+" and password = '"+password+"'");

        while(resultSet.next())
        {
            return true;
        }

        return false;
    }
    public boolean findbyUser_Pwd(String username, String password) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select id, username, password " +
                "from user where username = '" + username + "' COLLATE utf8mb4_bin " + " and password = '" + password + "' COLLATE utf8mb4_bin");


        while(resultSet.next()) {
            return true;
        }

        return false;
    }
}