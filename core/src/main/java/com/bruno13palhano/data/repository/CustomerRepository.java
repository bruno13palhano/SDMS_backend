package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.model.Customer;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomerRepository implements Repository<Customer> {

    @Override
    public void insert(Customer data) {
        String QUERY = "REPLACE INTO customer_table (id, name, photo, email, address, phone_number, time_stamp) " +
                "VALUES (?,?,?,?,?,?,?)";
        if (data.getId() == 0L) {
            QUERY = "INSERT INTO customer_table (name, photo, email, address, phone_number, time_stamp) " +
                    "VALUES (?,?,?,?,?,?)";
        }

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (data.getId() == 0L) {
                preparedStatement.setString(1, data.getName());
                preparedStatement.setBytes(2, data.getPhoto());
                preparedStatement.setString(3, data.getEmail());
                preparedStatement.setString(4, data.getAddress());
                preparedStatement.setString(5, data.getPhoneNumber());
                preparedStatement.setString(6, data.getTimestamp());
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setString(2, data.getName());
                preparedStatement.setBytes(3, data.getPhoto());
                preparedStatement.setString(4, data.getEmail());
                preparedStatement.setString(5, data.getAddress());
                preparedStatement.setString(6, data.getPhoneNumber());
                preparedStatement.setString(7, data.getTimestamp());
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer data) {
        String QUERY = "UPDATE customer_table SET name = ?, photo = ?, email = ?, address = ?, phone_number = ? " +
                "time_stamp = ? WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, data.getName());
            preparedStatement.setBytes(2, data.getPhoto());
            preparedStatement.setString(3, data.getEmail());
            preparedStatement.setString(4, data.getAddress());
            preparedStatement.setString(5, data.getPhoneNumber());
            preparedStatement.setString(6, data.getTimestamp());
            preparedStatement.setLong(7, data.getId());
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
    public List<Customer> getAll() {
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
                                resultSet.getString("phone_number"),
                                resultSet.getString("time_stamp")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
