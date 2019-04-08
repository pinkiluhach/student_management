package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


public class DbConnection {
    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            LOGGER.info("Dirver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");
            LOGGER.info("Connection established");
            LOGGER.fine("DB Connection successfully completed");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error Occur in DB Connection", e);
        }
        return connection;
    }
}











