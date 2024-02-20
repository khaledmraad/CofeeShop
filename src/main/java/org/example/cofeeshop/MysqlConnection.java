package org.example.cofeeshop;

import java.sql.*;

//or
//import java.sql.Connection; Manages a connection to a database,Once a connection is established, you can use it to execute SQL statements, retrieve results, and manage transactions with the database.
//import java.sql.DriverManager;  is a class that facilitates the management of database drivers and the establishment of connections to databases using those drivers.
//import java.sql.ResultSet; Represents the result set of a database query
//
//import java.sql.SQLException; Handles exceptions related to database operations
//import java.sql.Statement: Allows you to execute SQL statements on a database
public class MysqlConnection {
    public static void main(String[] args) {
        //step 0
        try {
            //Loading the MySQL JDBC driver class, which is necessary for database connectivity
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded!");

          //Catching and handling any exceptions related to loading the database driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //step 1: Connect to the database
        try {
            //Establishing a connection to a MySQL database hosted locally with the username “root” and password “root.” The database is named “sakila.”
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/CofeeShop","root","");
            //System.out.println(con);
            //Creating a statement object that can be used to execute SQL queries
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM users_cred";
            //Executing the SQL query and storing the result set in the rs variable
            ResultSet rs = stmt.executeQuery(sql);

            //Looping through each row in the result set
            while(rs.next())
                System.out.println(rs.getString("first_name")+"|"+rs.getString("last_name"));



            //Catching and handling any exceptions related to database operations
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
