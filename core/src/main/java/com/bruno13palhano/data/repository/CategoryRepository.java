package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.model.Category;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CategoryRepository implements Repository<Category> {
    private final Connection connection;

    public CategoryRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Category data) {
        String QUERY = "REPLACE INTO category_table (id, category, time_stamp) VALUES (?,?,?)";

        if (data.getId() == 0L) {
            QUERY = "INSERT INTO category_table (category, time_stamp) VALUES (?,?)";
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (data.getId() == 0L) {
                preparedStatement.setString(1, data.getCategory());
                preparedStatement.setString(2, data.getTimestamp());
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setString(2, data.getCategory());
                preparedStatement.setString(3, data.getTimestamp());
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category data) {
        String QUERY = "UPDATE category_table SET category = ?, time_stamp = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, data.getCategory());
            preparedStatement.setString(2, data.getTimestamp());
            preparedStatement.setLong(3, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM category_table WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> result = new ArrayList<>();
        String QUERY = "SELECT * FROM category_table";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(
                        new Category(
                                resultSet.getLong("id"),
                                resultSet.getString("category"),
                                resultSet.getString("time_stamp")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
