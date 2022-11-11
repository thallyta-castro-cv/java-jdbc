package com.thallyta.queries;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablePeople {

    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        String sql = "CREATE TABLE IF NOT EXISTS people ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(80) NOT NULL"
                    + ")";

        Statement statement = connection.createStatement();
        statement.execute(sql);

        System.out.println("Table created with success!");
        connection.close();
    }
}
