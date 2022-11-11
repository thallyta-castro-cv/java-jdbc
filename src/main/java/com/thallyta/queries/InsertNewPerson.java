package com.thallyta.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertNewPerson {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        String name = input.nextLine();

        Connection connection = ConnectionFactory.getConnection();

        String sql = "INSERT INTO people (name) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);

        statement.execute();

        System.out.println("Person registered successfully!");
        input.close();
    }
}
