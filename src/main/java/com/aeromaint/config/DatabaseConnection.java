package com.aeromaint.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/aeromaint?allowPublicKeyRetrieval=true&useSSL=false";

    private static final String USER = "root";

    private static final String PASSWORD = "WilsonPM1202";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exception) {
            throw new SQLException(
                    "No se pudo cargar el driver de MySQL.",
                    exception
            );
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
