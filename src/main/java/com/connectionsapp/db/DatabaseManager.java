package com.connectionsapp.db;

import java.sql.*;
import java.util.Objects;

import com.connectionsapp.models.Person;
public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    public DatabaseManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public boolean insertPerson(Person person) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO Persons (first_name, last_name, email, company, prefix, position_recruiting) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getFirst());
            preparedStatement.setString(2, person.getLast());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setString(4, person.getCompany());
            preparedStatement.setString(5, person.getPrefix());
            preparedStatement.setString(6, person.getPosition());

            int rowsInserted = preparedStatement.executeUpdate();
            return (rowsInserted > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while inserting data");
            return false;
        }


    }

    public String viewPerson(String last) {
        String sql = "SELECT * FROM Persons WHERE last_name = ?";
        StringBuilder result = new StringBuilder();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, last);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String company = resultSet.getString("company");
                String prefix = resultSet.getString("prefix");
                String position = resultSet.getString("position_recruiting");

                // Format the output
                result.append(prefix)
                        .append(" ")
                        .append(firstName)
                        .append(" ")
                        .append(lastName)
                        .append(", ")
                        .append("recruiting for ")
                        .append(position)
                        .append(" at ")
                        .append(company)
                        .append(" (Email: ")
                        .append(email)
                        .append(")\n");
            }
            if (result.length() == 0) {
                return "No person found with last name: " + last;


            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error while fetching data";


        }

    return result.toString();
    }
}