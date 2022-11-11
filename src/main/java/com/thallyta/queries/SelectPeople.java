package com.thallyta.queries;

import com.thallyta.models.PersonModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectPeople {

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM people";

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

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
    }
}
