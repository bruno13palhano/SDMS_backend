package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.Utils;
import com.bruno13palhano.model.Product;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ProductRepository implements Repository<Product> {

    @Override
    public void insert(Product data) {
        String INSERT_CATEGORIES_QUERY = "INSERT INTO product_categories_table (product_id, categories) VALUES (?,?)";
        String PRODUCT_ID_QUERY = "SELECT id FROM product_table WHERE id = LAST_INSERT_ID()";

        String categories = data.getCategories().stream()
                .map(c -> c.getId()+":"+c.getCategory())
                .collect(Collectors.joining(", "));

        String PRODUCT_QUERY = "INSERT INTO product_table (name,code,description,photo,date,company)" +
                "VALUES (?,?,?,?,?,?)";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement productPreparedStatement = connection.prepareStatement(PRODUCT_QUERY);
            productPreparedStatement.setString(1, data.getName());
            productPreparedStatement.setString(2, data.getCode());
            productPreparedStatement.setString(3, data.getDescription());
            productPreparedStatement.setBytes(4, data.getPhoto());
            productPreparedStatement.setLong(5, data.getDate());
            productPreparedStatement.setString(6, data.getCompany());
            productPreparedStatement.executeUpdate();

            PreparedStatement lastIdCategoriesPreparedStatement = connection.prepareStatement(PRODUCT_ID_QUERY);
            ResultSet lastIdResultSet = lastIdCategoriesPreparedStatement.executeQuery();
            lastIdResultSet.next();

            PreparedStatement insertCategoriesPreparedStatement = connection.prepareStatement(INSERT_CATEGORIES_QUERY);
            insertCategoriesPreparedStatement.setLong(1, lastIdResultSet.getLong("id"));
            insertCategoriesPreparedStatement.setString(2, categories);
            insertCategoriesPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product data) {
        String QUERY = "UPDATE product_table SET name = ?, code = ?, description = ?, photo = ?, date = ?, company = ? " +
                "WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2, data.getCode());
            preparedStatement.setString(3, data.getDescription());
            preparedStatement.setBytes(4, data.getPhoto());
            preparedStatement.setLong(5, data.getDate());
            preparedStatement.setString(6, data.getCompany());
            preparedStatement.setLong(7, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM product_table WHERE id = ?";

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
    public Iterable<Product> getAll() {
        List<Product> result = new ArrayList<>();
        String QUERY = "SELECT P.id, P.name, P.code, P.description, P.photo, P.date, PC.categories, P.company " +
                "FROM product_table P INNER JOIN product_categories_table PC ON P.id = PC.product_id";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(
                    new Product(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("code"),
                            resultSet.getString("description"),
                            resultSet.getBytes("photo"),
                            resultSet.getLong("date"),
                            Utils.stringToListOfCategory(resultSet.getString("categories")),
                            resultSet.getString("company")
                    )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
