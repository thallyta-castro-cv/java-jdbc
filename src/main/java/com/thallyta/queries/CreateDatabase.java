package com.thallyta.queries;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        Statement statement = connection.createStatement();
        statement.execute("CREATE DATABASE IF NOT EXISTS java_course");
        System.out.println("Database created with success!");

        connection.close();
    }
}
