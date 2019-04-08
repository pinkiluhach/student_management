package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Dirver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");
            System.out.println("Connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}











