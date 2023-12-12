package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.Utils;
import com.bruno13palhano.model.Delivery;
import com.bruno13palhano.model.Sale;
import com.bruno13palhano.model.StockItem;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SaleRepository implements Repository<Sale> {

    public void insertItems(Sale sale, StockItem stockItem, Delivery delivery) {
        String SALE_QUERY = "REPLACE INTO sale_table (id, product_id, stock_order_id, customer_id, quantity, " +
                "purchase_price, sale_price, date_of_sale, date_of_payment, is_ordered_by_customer, " +
                "is_paid_by_customer, canceled, time_stamp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String ITEMS_QUERY = "REPLACE INTO stock_table (id, product_id, date, validity, quantity, purchase_price, " +
                "sale_price, is_paid, time_stamp) VALUES (?,?,?,?,?,?,?,?,?)";

        String DELIVERY_QUERY = "REPLACE INTO delivery_table (id, sale_id, delivery_price, shipping_date, delivery_date, " +
                "delivered, time_stamp) VALUES (?,?,?,?,?,?,?)";

        if (sale.getId() == 0L) {
            SALE_QUERY = "INSERT INTO sale_table (product_id, stock_order_id, customer_id, quantity, purchase_price, " +
                    "sale_price, date_of_sale, date_of_payment, is_ordered_by_customer, is_paid_by_customer, " +
                    "canceled, time_stamp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            ITEMS_QUERY = "INSERT INTO stock_table (product_id, date, validity, quantity, purchase_price, " +
                    "sale_price, is_paid, time_stamp) VALUES (?,?,?,?,?,?,?,?)";

            DELIVERY_QUERY = "INSERT INTO delivery_table (sale_id, delivery_price, shipping_date, delivery_date, delivered, " +
                    "time_stamp) VALUES (?,?,?,?,?,?)";
        }

        String SALE_ID_QUERY = "SELECT id FROM sale_table WHERE id = LAST_INSERT_ID()";
        String ORDER_ID_QUERY = "SELECT id FROM stock_order_table WHERE id = LAST_INSERT_ID()";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement salePreparedStatement = connection.prepareStatement(SALE_QUERY);
            PreparedStatement itemsPreparedStatement = connection.prepareStatement(ITEMS_QUERY);
            PreparedStatement deliveryPreparedStatement = connection.prepareStatement(DELIVERY_QUERY);

            if (sale.getId() == 0L) {
                if (sale.getIsOrderedByCustomer()) {
                    salePreparedStatement.setLong(1, sale.getProductId());
                    salePreparedStatement.setLong(2, sale.getStockOrderId());
                    salePreparedStatement.setLong(3, sale.getCustomerId());
                    salePreparedStatement.setInt(4, sale.getQuantity());
                    salePreparedStatement.setFloat(5, sale.getPurchasePrice());
                    salePreparedStatement.setFloat(6, sale.getSalePrice());
                    salePreparedStatement.setLong(7, sale.getDateOfSale());
                    salePreparedStatement.setLong(8, sale.getDateOfPayment());
                    salePreparedStatement.setBoolean(9, sale.getIsOrderedByCustomer());
                    salePreparedStatement.setBoolean(10, sale.getIsPaidByCustomer());
                    salePreparedStatement.setBoolean(11, sale.getCanceled());
                    salePreparedStatement.setString(12, sale.getTimestamp());
                    salePreparedStatement.executeUpdate();

                    PreparedStatement saleLastIdPreparedStatement = connection.prepareStatement(SALE_ID_QUERY);
                    ResultSet lastIdResultSet = saleLastIdPreparedStatement.executeQuery();
                    lastIdResultSet.next();

                    deliveryPreparedStatement.setLong(1, lastIdResultSet.getLong("id"));
                    deliveryPreparedStatement.setFloat(2, delivery.getDeliveryPrice());
                    deliveryPreparedStatement.setLong(3, delivery.getShippingDate());
                    deliveryPreparedStatement.setLong(4, delivery.getDeliveryDate());
                    deliveryPreparedStatement.setBoolean(5, delivery.getDelivered());
                    deliveryPreparedStatement.setString(6, delivery.getTimestamp());
                    deliveryPreparedStatement.executeUpdate();

                } else {
                    Integer quantity = stockItem.getQuantity() - sale.getQuantity();
                    String UPDATE_STOCK_QUANTITY = "UPDATE stock_order_table SET quantity = ? WHERE id = ?";

                    PreparedStatement stockPreparedStatement = connection.prepareStatement(UPDATE_STOCK_QUANTITY);
                    stockPreparedStatement.setInt(1, quantity);
                    stockPreparedStatement.setLong(2, stockItem.getId());
                    stockPreparedStatement.executeUpdate();

                    salePreparedStatement.setLong(1, sale.getProductId());
                    salePreparedStatement.setLong(2, sale.getStockOrderId());
                    salePreparedStatement.setLong(3, sale.getCustomerId());
                    salePreparedStatement.setInt(4, sale.getQuantity());
                    salePreparedStatement.setFloat(5, sale.getPurchasePrice());
                    salePreparedStatement.setFloat(6, sale.getSalePrice());
                    salePreparedStatement.setLong(7, sale.getDateOfSale());
                    salePreparedStatement.setLong(8, sale.getDateOfPayment());
                    salePreparedStatement.setBoolean(9, sale.getIsOrderedByCustomer());
                    salePreparedStatement.setBoolean(10, sale.getIsPaidByCustomer());
                    salePreparedStatement.setBoolean(11, sale.getCanceled());
                    salePreparedStatement.setString(12, sale.getTimestamp());
                    salePreparedStatement.executeUpdate();

                    PreparedStatement saleLastIdPreparedStatement = connection.prepareStatement(SALE_ID_QUERY);
                    ResultSet lastIdResultSet = saleLastIdPreparedStatement.executeQuery();
                    lastIdResultSet.next();

                    deliveryPreparedStatement.setLong(1, lastIdResultSet.getLong("id"));
                    deliveryPreparedStatement.setFloat(2, delivery.getDeliveryPrice());
                    deliveryPreparedStatement.setLong(3, delivery.getShippingDate());
                    deliveryPreparedStatement.setLong(4, delivery.getDeliveryDate());
                    deliveryPreparedStatement.setBoolean(5, delivery.getDelivered());
                    deliveryPreparedStatement.setString(6, delivery.getTimestamp());
                    deliveryPreparedStatement.executeUpdate();
                }
            } else {
                if (sale.getIsOrderedByCustomer()) {
                    salePreparedStatement.setLong(1, sale.getId());
                    salePreparedStatement.setLong(2, sale.getProductId());
                    salePreparedStatement.setLong(3, sale.getStockOrderId());
                    salePreparedStatement.setLong(4, sale.getCustomerId());
                    salePreparedStatement.setInt(5, sale.getQuantity());
                    salePreparedStatement.setFloat(6, sale.getPurchasePrice());
                    salePreparedStatement.setFloat(7, sale.getSalePrice());
                    salePreparedStatement.setLong(8, sale.getDateOfSale());
                    salePreparedStatement.setLong(9, sale.getDateOfPayment());
                    salePreparedStatement.setBoolean(10, sale.getIsOrderedByCustomer());
                    salePreparedStatement.setBoolean(11, sale.getIsPaidByCustomer());
                    salePreparedStatement.setBoolean(12, sale.getCanceled());
                    salePreparedStatement.setString(13, sale.getTimestamp());
                    salePreparedStatement.executeUpdate();

                    deliveryPreparedStatement.setLong(1, delivery.getId());
                    deliveryPreparedStatement.setLong(2, sale.getId());
                    deliveryPreparedStatement.setFloat(3, delivery.getDeliveryPrice());
                    deliveryPreparedStatement.setLong(4, delivery.getShippingDate());
                    deliveryPreparedStatement.setLong(5, delivery.getDeliveryDate());
                    deliveryPreparedStatement.setBoolean(6, delivery.getDelivered());
                    deliveryPreparedStatement.setString(7, delivery.getTimestamp());
                    deliveryPreparedStatement.executeUpdate();

                } else {
                    Integer quantity = stockItem.getQuantity() - sale.getQuantity();
                    String UPDATE_STOCK_QUANTITY = "UPDATE stock_order_table SET quantity = ? WHERE id = ?";

                    PreparedStatement stockPreparedStatement = connection.prepareStatement(UPDATE_STOCK_QUANTITY);
                    stockPreparedStatement.setInt(1, quantity);
                    stockPreparedStatement.setLong(2, stockItem.getId());
                    stockPreparedStatement.executeUpdate();

                    salePreparedStatement.setLong(1, sale.getId());
                    salePreparedStatement.setLong(2, sale.getProductId());
                    salePreparedStatement.setLong(3, sale.getStockOrderId());
                    salePreparedStatement.setLong(4, sale.getCustomerId());
                    salePreparedStatement.setInt(5, sale.getQuantity());
                    salePreparedStatement.setFloat(6, sale.getPurchasePrice());
                    salePreparedStatement.setFloat(7, sale.getSalePrice());
                    salePreparedStatement.setLong(8, sale.getDateOfSale());
                    salePreparedStatement.setLong(9, sale.getDateOfPayment());
                    salePreparedStatement.setBoolean(10, sale.getIsOrderedByCustomer());
                    salePreparedStatement.setBoolean(11, sale.getIsPaidByCustomer());
                    salePreparedStatement.setBoolean(12, sale.getCanceled());
                    salePreparedStatement.setString(13, sale.getTimestamp());
                    salePreparedStatement.executeUpdate();

                    deliveryPreparedStatement.setLong(1, delivery.getId());
                    deliveryPreparedStatement.setLong(2, sale.getId());
                    deliveryPreparedStatement.setFloat(3, delivery.getDeliveryPrice());
                    deliveryPreparedStatement.setLong(4, delivery.getShippingDate());
                    deliveryPreparedStatement.setLong(5, delivery.getDeliveryDate());
                    deliveryPreparedStatement.setBoolean(6, delivery.getDelivered());
                    deliveryPreparedStatement.setString(7, delivery.getTimestamp());
                    deliveryPreparedStatement.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Sale data) {
        String QUERY = "REPLACE INTO sale_table (id, product_id, stock_order_id, customer_id, quantity, " +
                "purchase_price, sale_price, date_of_sale, date_of_payment, is_ordered_by_customer, " +
                "is_paid_by_customer, canceled, time_stamp) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

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
                preparedStatement.setString(12, data.getTimestamp());
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
                preparedStatement.setString(13, data.getTimestamp());
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
            preparedStatement.setString(9, data.getTimestamp());
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
    public List<Sale> getAll() {
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