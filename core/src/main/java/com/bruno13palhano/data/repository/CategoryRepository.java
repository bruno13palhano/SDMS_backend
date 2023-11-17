package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.model.Category;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CategoryRepository implements Repository<Category> {
    @Override
    public void insert(Category data) {
        String QUERY = "INSERT INTO category_table (category) VALUES (?)";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, data.getCategory());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category data) {
        String QUERY = "UPDATE category_table SET category = ? WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, data.getCategory());
            preparedStatement.setLong(2, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM category_table WHERE id = ?";

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
    public Iterable<Category> getAll() {
        List<Category> result = new ArrayList<>();
        String QUERY = "SELECT * FROM category_table";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(
                        new Category(
                                resultSet.getLong("id"),
                                resultSet.getString("category")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
