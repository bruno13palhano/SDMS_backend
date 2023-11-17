package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {

    @Override
    public void insert(Customer data) {
        String QUERY = "INSERT INTO customer_table (name, photo, email, address, phone_number) VALUES (?,?,?,?,?)";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, data.getName());
            preparedStatement.setBytes(2, data.getPhoto());
            preparedStatement.setString(3, data.getEmail());
            preparedStatement.setString(4, data.getAddress());
            preparedStatement.setString(5, data.getPhoneNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer data) {
        String QUERY = "UPDATE customer_table SET name = ?, photo = ?, email = ?, address = ?, phone_number = ? " +
                "WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, data.getName());
            preparedStatement.setBytes(2, data.getPhoto());
            preparedStatement.setString(3, data.getEmail());
            preparedStatement.setString(4, data.getAddress());
            preparedStatement.setString(5, data.getPhoneNumber());
            preparedStatement.setLong(6, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM customer_table WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        String QUERY = "SELECT * FROM customer_table";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getBytes("photo"),
                                resultSet.getString("email"),
                                resultSet.getString("address"),
                                resultSet.getString("phone_number")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
