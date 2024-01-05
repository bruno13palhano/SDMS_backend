package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.model.Catalog;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CatalogRepository implements Repository<Catalog> {
    private final Connection connection;

    public CatalogRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Catalog data) {
        String QUERY = "REPLACE INTO catalog_table (id, product_id, title, description, discount, price, " +
                "time_stamp) VALUES (?,?,?,?,?,?,?)";

        if (data.getId() == 0L) {
            QUERY = "INSERT INTO catalog_table (product_id, title, description, discount, price, time_stamp) " +
                    "VALUES (?,?,?,?,?,?)";
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            if (data.getId() == 0L) {
                preparedStatement.setLong(1, data.getProductId());
                preparedStatement.setString(2, data.getTitle());
                preparedStatement.setString(3, data.getDescription());
                preparedStatement.setInt(4, data.getDiscount());
                preparedStatement.setFloat(5, data.getPrice());
                preparedStatement.setString(6, data.getTimestamp());
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setLong(2, data.getProductId());
                preparedStatement.setString(3, data.getTitle());
                preparedStatement.setString(4, data.getDescription());
                preparedStatement.setInt(5, data.getDiscount());
                preparedStatement.setFloat(6, data.getPrice());
                preparedStatement.setString(7, data.getTimestamp());
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Catalog data) {
        String QUERY = "UPDATE catalog_table SET product_id = ?, title = ?, description = ?, discount = ?, " +
                "price = ?, time_stamp = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, data.getProductId());
            preparedStatement.setString(2, data.getTitle());
            preparedStatement.setString(3, data.getDescription());
            preparedStatement.setInt(4, data.getDiscount());
            preparedStatement.setFloat(5, data.getPrice());
            preparedStatement.setString(6, data.getTimestamp());
            preparedStatement.setLong(7, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM catalog_table WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Catalog> getAll() {
        List<Catalog> result = new ArrayList<>();
        String QUERY = "SELECT C.id, C.product_id, P.name, P.photo, C.title, C.description, C.discount, C.price, " +
                "C.time_stamp FROM product_table P INNER JOIN catalog_table C ON(P.id = C.product_id)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                result.add(
                        new Catalog(
                                resultSet.getLong("id"),
                                resultSet.getLong("product_id"),
                                resultSet.getString("name"),
                                resultSet.getBytes("photo"),
                                resultSet.getString("title"),
                                resultSet.getString("description"),
                                resultSet.getInt("discount"),
                                resultSet.getFloat("price"),
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
