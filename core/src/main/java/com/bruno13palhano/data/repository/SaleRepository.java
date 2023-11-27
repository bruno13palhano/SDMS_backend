package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.Utils;
import com.bruno13palhano.model.Sale;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SaleRepository implements Repository<Sale> {

    @Override
    public void insert(Sale data) {
        String QUERY = "INSERT INTO sale_table (id, product_id, stock_order_id, customer_id, quantity, " +
                "purchase_price, sale_price, date_of_sale, date_of_payment, is_ordered_by_customer, " +
                "is_paid_by_customer, canceled, time_stamp) VALUES (??,?,?,?,?,?,?,?,?,?,?,?)";

        if (data.getId() == 0L) {
            QUERY = "INSERT INTO sale_table (product_id, stock_order_id, customer_id, quantity, purchase_price, " +
                    "sale_price, date_of_sale, date_of_payment, is_ordered_by_customer, is_paid_by_customer, " +
                    "canceled, time_stamp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (data.getId() == 0L) {
                preparedStatement.setLong(1, data.getProductId());
                preparedStatement.setLong(2, data.getStockOrderId());
                preparedStatement.setLong(3, data.getCustomerId());
                preparedStatement.setInt(4, data.getQuantity());
                preparedStatement.setFloat(5, data.getPurchasePrice());
                preparedStatement.setFloat(6, data.getSalePrice());
                preparedStatement.setLong(7, data.getDateOfSale());
                preparedStatement.setLong(8, data.getDateOfPayment());
                preparedStatement.setBoolean(9, data.getIsOrderedByCustomer());
                preparedStatement.setBoolean(10, data.getIsPaidByCustomer());
                preparedStatement.setBoolean(11, data.getCanceled());
                preparedStatement.setTimestamp(12, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setLong(2, data.getProductId());
                preparedStatement.setLong(3, data.getStockOrderId());
                preparedStatement.setLong(4, data.getCustomerId());
                preparedStatement.setInt(5, data.getQuantity());
                preparedStatement.setFloat(6, data.getPurchasePrice());
                preparedStatement.setFloat(7, data.getSalePrice());
                preparedStatement.setLong(8, data.getDateOfSale());
                preparedStatement.setLong(9, data.getDateOfPayment());
                preparedStatement.setBoolean(10, data.getIsOrderedByCustomer());
                preparedStatement.setBoolean(11, data.getIsPaidByCustomer());
                preparedStatement.setBoolean(12, data.getCanceled());
                preparedStatement.setTimestamp(13, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Sale data) {
        String QUERY = "UPDATE sale_table SET customer_id = ?, quantity = ?, purchase_price = ?, sale_price = ?, " +
                "date_of_sale = ?, date_of_payment = ?, is_paid_by_customer = ?, canceled = ?, time_stamp = ? " +
                "WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, data.getCustomerId());
            preparedStatement.setInt(2, data.getQuantity());
            preparedStatement.setFloat(3, data.getPurchasePrice());
            preparedStatement.setFloat(4, data.getSalePrice());
            preparedStatement.setLong(5, data.getDateOfSale());
            preparedStatement.setLong(6, data.getDateOfPayment());
            preparedStatement.setBoolean(7, data.getIsPaidByCustomer());
            preparedStatement.setBoolean(8, data.getCanceled());
            preparedStatement.setTimestamp(9, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            preparedStatement.setLong(10, data.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM sale_table WHERE id = ?";

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
    public Iterable<Sale> getAll() {
        List<Sale> sales = new ArrayList<>();
        String QUERY = "SELECT S.id, S.product_id, S.stock_order_id, S.customer_id, P.name, C.name as customer_name, " +
                "P.photo, S.quantity, S.purchase_price, S.sale_price, D.delivery_price, PC.categories, P.company, " +
                "S.date_of_sale, S.date_of_payment, S.is_ordered_by_customer, S.is_paid_by_customer, S.canceled, " +
                "S.time_stamp " +
                "FROM product_table P INNER JOIN sale_table S INNER JOIN product_categories_table PC " +
                "INNER JOIN customer_table C INNER JOIN delivery_table D " +
                "ON(P.id = PC.product_id AND P.id = S.product_id AND S.customer_id = C.id AND D.sale_id = S.id) " +
                "WHERE S.canceled = 0";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                sales.add(
                        new Sale(
                                resultSet.getLong("id"),
                                resultSet.getLong("product_id"),
                                resultSet.getLong("stock_order_id"),
                                resultSet.getLong("customer_id"),
                                resultSet.getString("name"),
                                resultSet.getString("customer_name"),
                                resultSet.getBytes("photo"),
                                resultSet.getInt("quantity"),
                                resultSet.getFloat("purchase_price"),
                                resultSet.getFloat("sale_price"),
                                resultSet.getFloat("delivery_price"),
                                Utils.stringToListOfCategory(resultSet.getString("categories")),
                                resultSet.getString("company"),
                                resultSet.getLong("date_of_sale"),
                                resultSet.getLong("date_of_payment"),
                                resultSet.getBoolean("is_ordered_by_customer"),
                                resultSet.getBoolean("is_paid_by_customer"),
                                resultSet.getBoolean("canceled"),
                                resultSet.getObject("time_stamp", OffsetDateTime.class)
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sales;
    }
}