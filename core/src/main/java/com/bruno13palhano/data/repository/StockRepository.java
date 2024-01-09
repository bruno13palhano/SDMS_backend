package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.Utils;
import com.bruno13palhano.model.StockItem;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StockRepository implements Repository<StockItem> {
    private final Connection connection;

    public StockRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(StockItem data) {
        String QUERY = "REPLACE INTO stock_table (id, product_id, date, date_of_payment, validity, quantity, " +
                "purchase_price, sale_price, is_paid, time_stamp) VALUES (?,?,?,?,?,?,?,?,?,?)";

        if (data.getId() == 0L) {
            QUERY = "INSERT INTO stock_table (product_id, date, date_of_payment, validity, quantity, purchase_price, " +
                    "sale_price, is_paid, time_stamp) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (data.getId() == 0L) {
                preparedStatement.setLong(1, data.getProductId());
                preparedStatement.setLong(2, data.getDate());
                preparedStatement.setLong(3, data.getDateOfPayment());
                preparedStatement.setLong(4, data.getValidity());
                preparedStatement.setInt(5, data.getQuantity());
                preparedStatement.setFloat(6, data.getPurchasePrice());
                preparedStatement.setFloat(7, data.getSalePrice());
                preparedStatement.setBoolean(8, data.getIsPaid());
                preparedStatement.setString(9, data.getTimestamp());
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setLong(2, data.getProductId());
                preparedStatement.setLong(3, data.getDate());
                preparedStatement.setLong(4, data.getDateOfPayment());
                preparedStatement.setLong(5, data.getValidity());
                preparedStatement.setInt(6, data.getQuantity());
                preparedStatement.setFloat(7, data.getPurchasePrice());
                preparedStatement.setFloat(8, data.getSalePrice());
                preparedStatement.setBoolean(9, data.getIsPaid());
                preparedStatement.setString(10, data.getTimestamp());
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(StockItem data) {
        String QUERY = "UPDATE stock_table SET product_id = ?, date = ?, date_of_payment, validity = ?, " +
                "quantity = ?, purchase_price = ?, sale_price = ?, is_paid = ?, time_stamp = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, data.getProductId());
            preparedStatement.setLong(2, data.getDate());
            preparedStatement.setLong(3, data.getValidity());
            preparedStatement.setLong(4, data.getDateOfPayment());
            preparedStatement.setInt(5, data.getQuantity());
            preparedStatement.setFloat(6, data.getPurchasePrice());
            preparedStatement.setFloat(7, data.getSalePrice());
            preparedStatement.setBoolean(8, data.getIsPaid());
            preparedStatement.setString(9, data.getTimestamp());
            preparedStatement.setLong(10, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStockItemQuantity(Long id, Integer quantity) {
        String QUERY = "UPDATE stock_table SET quantity = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM stock_table WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StockItem> getAll() {
        List<StockItem> stockItemList = new ArrayList<>();
        String QUERY = "SELECT S.id, S.product_id, P.name, P.photo, S.date, S.date_of_payment, S.validity, " +
                "S.quantity, PC.categories, P.company, S.purchase_price, S.sale_price, S.is_paid, S.time_stamp " +
                "FROM product_table P INNER JOIN stock_table S INNER JOIN product_categories_table PC " +
                "ON(P.id = PC.product_id AND P.id = S.product_id)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                stockItemList.add(
                        new StockItem(
                                resultSet.getLong("id"),
                                resultSet.getLong("product_id"),
                                resultSet.getString("name"),
                                resultSet.getBytes("photo"),
                                resultSet.getLong("date"),
                                resultSet.getLong("date_of_payment"),
                                resultSet.getLong("validity"),
                                resultSet.getInt("quantity"),
                                Utils.stringToListOfCategory(resultSet.getString("categories")),
                                resultSet.getString("company"),
                                resultSet.getFloat("purchase_price"),
                                resultSet.getFloat("sale_price"),
                                resultSet.getBoolean("is_paid"),
                                resultSet.getString("time_stamp")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stockItemList;
    }
}
