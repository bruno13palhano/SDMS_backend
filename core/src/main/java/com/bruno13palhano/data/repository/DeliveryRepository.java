package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.model.Delivery;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class DeliveryRepository implements Repository<Delivery> {

    @Override
    public void insert(Delivery data) {
        String QUERY = "INSERT INTO delivery_table (sale_id, delivery_price, shipping_date, delivery_date, delivered) " +
                "VALUES (?,?,?,?,?)";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, data.getSaleId());
            preparedStatement.setFloat(2, data.getDeliveryPrice());
            preparedStatement.setLong(3, data.getShippingDate());
            preparedStatement.setLong(4, data.getDeliveryDate());
            preparedStatement.setBoolean(5, data.getDelivered());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Delivery data) {
        String QUERY = "UPDATE delivery_table SET delivery_price = ?, shipping_date = ?, delivery_date = ?, " +
                "delivered = ? WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setFloat(1, data.getDeliveryPrice());
            preparedStatement.setLong(2, data.getDeliveryDate());
            preparedStatement.setLong(3, data.getShippingDate());
            preparedStatement.setBoolean(4, data.getDelivered());
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
        return null;
    }
}
