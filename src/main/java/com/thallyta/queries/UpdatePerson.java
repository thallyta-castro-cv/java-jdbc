package com.thallyta.queries;

import com.thallyta.models.PersonModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePerson {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);

        System.out.print("Informe o id da pessoa: ");
        int id = input.nextInt();

        String selectSQL = "SELECT id, name FROM people WHERE id = ?";
        String updateSQL = "UPDATE people SET name = ? WHERE id = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(selectSQL);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        if(result.next()) {
            PersonModel person = new PersonModel(result.getInt(1), result.getString(2));

            System.out.println("O nome atual é " + person.getName());
            input.nextLine();

            System.out.print("Informe o novo nome: ");
            String newName = input.nextLine();

            statement.close();

            statement = connection.prepareStatement(updateSQL);
            statement.setString(1, newName);
            statement.setInt(2, id);
            statement.execute();

            System.out.println("Pessoa alterada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada!");
        }

        connection.close();
        input.close();
    }
}
