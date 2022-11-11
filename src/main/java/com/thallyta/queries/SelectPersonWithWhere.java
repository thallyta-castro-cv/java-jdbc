package com.thallyta.queries;

import com.thallyta.models.PersonModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectPersonWithWhere {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);

        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM people WHERE NAME LIKE ? ";

        System.out.print("Informe o valor pra pesquisa: ");
        String value = input.nextLine();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + value + "%");
        ResultSet result = statement.executeQuery();

        List<PersonModel> people = new ArrayList<PersonModel>();

        while(result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            people.add(new PersonModel(id, name));
        }

        for(PersonModel person: people) {
            System.out.println(person.getId() + " ==> " + person.getName());
        }

        statement.close();
        connection.close();
        input.close();
    }
}
