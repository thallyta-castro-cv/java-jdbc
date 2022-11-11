package com.thallyta.queries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {

        try {
            Properties properties = getProperties();
            final String url = properties.getProperty("database.url");
            final String user = properties.getProperty("database.user");
            final String password = properties.getProperty("database.password");

            return  DriverManager.getConnection(url, user, password);

        } catch (SQLException | IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        String path = "/application.properties";
        properties.load(ConnectionFactory.class.getResourceAsStream(path));
        return properties;
    }
}
