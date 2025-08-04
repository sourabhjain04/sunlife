package com.JdbcCrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

private static final String URL="jdbc:mysql://localhost:3306/employee";
private static final String USER="root";
private static final String PASSWORD="root";


    public static Connection getConnection() throws SQLException {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            throw new SQLException("MYSQL Driver not found,"+ e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
