package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.Utils;
import com.bruno13palhano.model.StockOrder;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StockOrderRepository implements Repository<StockOrder> {

    @Override
    public void insert(StockOrder data) {
        String QUERY = "INSERT INTO stock_order_table (id, product_id, date, validity, quantity, purchase_price, " +
                "sale_price, is_ordered_by_customer, is_paid, time_stamp) VALUES (?,?,?,?,?,?,?,?,?,?)";

        if (data.getId() == 0L) {
            QUERY = "INSERT INTO stock_order_table (product_id, date, validity, quantity, purchase_price, " +
                    "sale_price, is_ordered_by_customer, is_paid, time_stamp) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (data.getId() == 0L) {
                preparedStatement.setLong(1, data.getProductId());
                preparedStatement.setLong(2, data.getDate());
                preparedStatement.setLong(3, data.getValidity());
                preparedStatement.setInt(4, data.getQuantity());
                preparedStatement.setFloat(5, data.getPurchasePrice());
                preparedStatement.setFloat(6, data.getSalePrice());
                preparedStatement.setBoolean(7, data.getIsOrderedByCustomer());
                preparedStatement.setBoolean(8, data.getIsPaid());
                preparedStatement.setTimestamp(9, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setLong(2, data.getProductId());
                preparedStatement.setLong(3, data.getDate());
                preparedStatement.setLong(4, data.getValidity());
                preparedStatement.setInt(5, data.getQuantity());
                preparedStatement.setFloat(6, data.getPurchasePrice());
                preparedStatement.setFloat(7, data.getSalePrice());
                preparedStatement.setBoolean(8, data.getIsOrderedByCustomer());
                preparedStatement.setBoolean(9, data.getIsPaid());
                preparedStatement.setTimestamp(10, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(StockOrder data) {
        String QUERY = "UPDATE stock_order_table SET product_id = ?, date = ?, validity = ?, quantity = ?, " +
                "purchase_price = ?, ale_price = ?, is_paid = ?, time_stamp = ? WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, data.getProductId());
            preparedStatement.setLong(2, data.getDate());
            preparedStatement.setLong(3, data.getValidity());
            preparedStatement.setInt(4, data.getQuantity());
            preparedStatement.setFloat(5, data.getPurchasePrice());
            preparedStatement.setFloat(6, data.getSalePrice());
            preparedStatement.setBoolean(7, data.getIsPaid());
            preparedStatement.setTimestamp(8, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            preparedStatement.setLong(9, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM stock_order_table WHERE id = ?";

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
    public Iterable<StockOrder> getAll() {
        List<StockOrder> stockOrderList = new ArrayList<>();
        String QUERY = "SELECT S.id, S.product_id, P.name, P.photo, S.date, S.validity, S.quantity, PC.categories, " +
                "P.company, S.purchase_price, S.sale_price, S.is_ordered_by_customer, S.is_paid, S.time_stamp " +
                "FROM product_table P INNER JOIN stock_order_table S INNER JOIN product_categories_table PC " +
                "ON(P.id = PC.product_id AND P.id = S.product_id)";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                stockOrderList.add(
                        new StockOrder(
                                resultSet.getLong("id"),
                                resultSet.getLong("product_id"),
                                resultSet.getString("name"),
                                resultSet.getBytes("photo"),
                                resultSet.getLong("date"),
                                resultSet.getLong("validity"),
                                resultSet.getInt("quantity"),
                                Utils.stringToListOfCategory(resultSet.getString("categories")),
                                resultSet.getString("company"),
                                resultSet.getFloat("purchase_price"),
                                resultSet.getFloat("sale_price"),
                                resultSet.getBoolean("is_ordered_by_customer"),
                                resultSet.getBoolean("is_paid"),
                                resultSet.getObject("time_stamp", OffsetDateTime.class)
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stockOrderList;
    }
}
