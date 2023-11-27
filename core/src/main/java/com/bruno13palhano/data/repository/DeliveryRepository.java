package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.model.Delivery;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DeliveryRepository implements Repository<Delivery> {

    @Override
    public void insert(Delivery data) {
        String QUERY = "INSERT INTO delivery_table (id, sale_id, delivery_price, shipping_date, delivery_date, " +
                "delivered, time_stamp) VALUES (?,?,?,?,?,?,?)";

        if (data.getId() == 0L) {
            QUERY = "INSERT INTO delivery_table (sale_id, delivery_price, shipping_date, delivery_date, delivered, " +
                    "time_stamp) VALUES (?,?,?,?,?,?)";
        }

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (data.getId() == 0L) {
                preparedStatement.setLong(1, data.getSaleId());
                preparedStatement.setFloat(2, data.getDeliveryPrice());
                preparedStatement.setLong(3, data.getShippingDate());
                preparedStatement.setLong(4, data.getDeliveryDate());
                preparedStatement.setBoolean(5, data.getDelivered());
                preparedStatement.setTimestamp(6, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setLong(2, data.getSaleId());
                preparedStatement.setFloat(3, data.getDeliveryPrice());
                preparedStatement.setLong(4, data.getShippingDate());
                preparedStatement.setLong(5, data.getDeliveryDate());
                preparedStatement.setBoolean(6, data.getDelivered());
                preparedStatement.setTimestamp(7, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Delivery data) {
        String QUERY = "UPDATE delivery_table SET delivery_price = ?, shipping_date = ?, delivery_date = ?, " +
                "delivered = ?, time_stamp = ? WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setFloat(1, data.getDeliveryPrice());
            preparedStatement.setLong(2, data.getDeliveryDate());
            preparedStatement.setLong(3, data.getShippingDate());
            preparedStatement.setBoolean(4, data.getDelivered());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            preparedStatement.setLong(6, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM delivery_table WHERE id = ?";

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
    public Iterable<Delivery> getAll() {
        List<Delivery> deliveries = new ArrayList<>();
        String QUERY = "SELECT D.id, D.sale_id, C.name AS customer_name, C.address, C.phone_number, " +
                "P.name AS product_name, S.sale_price AS price, D.delivery_price, D.shipping_date, D.delivery_date, " +
                "D.delivered S.time_stamp " +
                "FROM delivery_table AS D INNER JOIN product_table AS P INNER JOIN sale_table AS S " +
                "INNER JOIN customer_table AS C ON(D.sale_id = S.id AND C.id = S.customer_id)";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                deliveries.add(
                        new Delivery(
                                resultSet.getLong("id"),
                                resultSet.getLong("sale_id"),
                                resultSet.getString("customer_name"),
                                resultSet.getString("address"),
                                resultSet.getString("phone_number"),
                                resultSet.getString("product_name"),
                                resultSet.getFloat("price"),
                                resultSet.getFloat("delivery_price"),
                                resultSet.getLong("shipping_date"),
                                resultSet.getLong("delivery_date"),
                                resultSet.getBoolean("delivered"),
                                resultSet.getObject("time_stamp", OffsetDateTime.class)
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deliveries;
    }
}
