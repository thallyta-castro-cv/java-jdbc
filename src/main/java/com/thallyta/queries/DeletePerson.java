package com.thallyta.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePerson {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);

        System.out.print("Informe o id para ser excluído: ");
        int id = input.nextInt();

        Connection connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM people WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        int counter = statement.executeUpdate();

        if(counter > 0) {
            System.out.println("Pessoa excluida com sucesso!");
        } else {
            System.out.println("O registro que você está tentado excluir não existe!");
        }

        System.out.println("Linhas afetadas: " + counter);

        connection.close();
        input.close();
    }
}
