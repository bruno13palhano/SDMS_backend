package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.Utils;
import com.bruno13palhano.model.Sale;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SaleRepository implements Repository<Sale> {

    @Override
    public void insert(Sale data) {
        String QUERY = "REPLACE INTO sale_table (id, product_id, stock_id, customer_id, quantity, " +
                "purchase_price, sale_price, delivery_price, date_of_sale, date_of_payment, shipping_date, " +
                "delivery_date, is_ordered_by_customer, is_paid_by_customer, delivered, canceled, time_stamp) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        if (data.getId() == 0L) {
            QUERY = "INSERT INTO sale_table (product_id, stock_id, customer_id, quantity, " +
                    "purchase_price, sale_price, delivery_price, date_of_sale, date_of_payment, shipping_date, " +
                    "delivery_date, is_ordered_by_customer, is_paid_by_customer, delivered, canceled, time_stamp) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (data.getId() == 0L) {
                preparedStatement.setLong(1, data.getProductId());
                preparedStatement.setLong(2, data.getStockId());
                preparedStatement.setLong(3, data.getCustomerId());
                preparedStatement.setInt(4, data.getQuantity());
                preparedStatement.setFloat(5, data.getPurchasePrice());
                preparedStatement.setFloat(6, data.getSalePrice());
                preparedStatement.setFloat(7, data.getDeliveryPrice());
                preparedStatement.setLong(8, data.getDateOfSale());
                preparedStatement.setLong(9, data.getDateOfPayment());
                preparedStatement.setLong(10, data.getShippingDate());
                preparedStatement.setLong(11, data.getDeliveryDate());
                preparedStatement.setBoolean(12, data.getIsOrderedByCustomer());
                preparedStatement.setBoolean(13, data.getIsPaidByCustomer());
                preparedStatement.setBoolean(14, data.getDelivered());
                preparedStatement.setBoolean(15, data.getCanceled());
                preparedStatement.setString(16, data.getTimestamp());
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setLong(2, data.getProductId());
                preparedStatement.setLong(3, data.getStockId());
                preparedStatement.setLong(4, data.getCustomerId());
                preparedStatement.setInt(5, data.getQuantity());
                preparedStatement.setFloat(6, data.getPurchasePrice());
                preparedStatement.setFloat(7, data.getSalePrice());
                preparedStatement.setFloat(8, data.getDeliveryPrice());
                preparedStatement.setLong(9, data.getDateOfSale());
                preparedStatement.setLong(10, data.getDateOfPayment());
                preparedStatement.setLong(11, data.getShippingDate());
                preparedStatement.setLong(12, data.getDeliveryDate());
                preparedStatement.setBoolean(13, data.getIsOrderedByCustomer());
                preparedStatement.setBoolean(14, data.getIsPaidByCustomer());
                preparedStatement.setBoolean(15, data.getDelivered());
                preparedStatement.setBoolean(16, data.getCanceled());
                preparedStatement.setString(17, data.getTimestamp());
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Sale data) {
        String QUERY = "UPDATE sale_table SET product_id = ?, customer_id = ?, stock_id = ?, quantity = ?, " +
                "purchase_price = ?, sale_price = ?, delivery_price = ?, date_of_sale = ?, date_of_payment = ?, " +
                "shipping_date = ?, delivery_date = ?, is_ordered_by_customer = ?, is_paid_by_customer = ?, " +
                "delivered = ?, canceled = ?, time_stamp = ? " +
                "WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, data.getProductId());
            preparedStatement.setLong(2, data.getCustomerId());
            preparedStatement.setLong(3, data.getStockId());
            preparedStatement.setInt(4, data.getQuantity());
            preparedStatement.setFloat(5, data.getPurchasePrice());
            preparedStatement.setFloat(6, data.getSalePrice());
            preparedStatement.setFloat(7, data.getDeliveryPrice());
            preparedStatement.setLong(8, data.getDateOfSale());
            preparedStatement.setLong(9, data.getDateOfPayment());
            preparedStatement.setLong(10, data.getShippingDate());
            preparedStatement.setLong(11, data.getDeliveryDate());
            preparedStatement.setBoolean(12, data.getIsPaidByCustomer());
            preparedStatement.setBoolean(13, data.getDelivered());
            preparedStatement.setBoolean(14, data.getCanceled());
            preparedStatement.setString(15, data.getTimestamp());
            preparedStatement.setLong(16, data.getId());
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
    public List<Sale> getAll() {
        List<Sale> sales = new ArrayList<>();
        String QUERY = "SELECT S.id, S.product_id, S.stock_id, S.customer_id, P.name, C.name as customer_name, " +
                "P.photo, C.address, C.phone_number, S.quantity, S.purchase_price, S.sale_price, S.delivery_price, " +
                "PC.categories, P.company, S.date_of_sale, S.date_of_payment, S.shipping_date, S.delivery_date, " +
                "S.is_ordered_by_customer, S.is_paid_by_customer, S.delivered, S.canceled, S.time_stamp " +
                "FROM product_table P INNER JOIN sale_table S INNER JOIN product_categories_table PC " +
                "INNER JOIN customer_table C " +
                "ON(P.id = PC.product_id AND P.id = S.product_id AND S.customer_id = C.id) " +
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
                                resultSet.getLong("stock_id"),
                                resultSet.getLong("customer_id"),
                                resultSet.getString("name"),
                                resultSet.getString("customer_name"),
                                resultSet.getBytes("photo"),
                                resultSet.getString("address"),
                                resultSet.getString("phone_number"),
                                resultSet.getInt("quantity"),
                                resultSet.getFloat("purchase_price"),
                                resultSet.getFloat("sale_price"),
                                resultSet.getFloat("delivery_price"),
                                Utils.stringToListOfCategory(resultSet.getString("categories")),
                                resultSet.getString("company"),
                                resultSet.getLong("date_of_sale"),
                                resultSet.getLong("date_of_payment"),
                                resultSet.getLong("shipping_date"),
                                resultSet.getLong("delivery_date"),
                                resultSet.getBoolean("is_ordered_by_customer"),
                                resultSet.getBoolean("is_paid_by_customer"),
                                resultSet.getBoolean("delivered"),
                                resultSet.getBoolean("canceled"),
                                resultSet.getString("time_stamp")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sales;
    }
}