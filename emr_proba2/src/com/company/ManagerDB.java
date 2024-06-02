package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManagerDB {

    private Connection connection;

    private static String url="jdbc:mariadb://localhost:3306/erm";
    private static String user="root";
    private static String pwd="password";

    public ManagerDB() throws SQLException {
            connection = DriverManager.getConnection(url, user, pwd);
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection()
    {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
