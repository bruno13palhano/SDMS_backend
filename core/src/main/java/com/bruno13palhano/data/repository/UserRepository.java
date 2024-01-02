package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.UserData;
import com.bruno13palhano.model.User;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class UserRepository implements UserData<User> {

    @Override
    public void insert(User user) {
        String QUERY = "REPLACE INTO users (id, username, password, email, photo, role, enabled, time_stamp) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        if (user.getId() == 0L) {
            QUERY = "INSERT INTO users (username, password, email, photo, role, enabled, time_stamp) " +
                    "VALUES (?,?,?,?,?,?,?)";
        }

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (user.getId() == 0L) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setBytes(4, user.getPhoto());
                preparedStatement.setString(5, user.getRole());
                preparedStatement.setBoolean(6, user.getEnabled());
                preparedStatement.setString(7, user.getTimestamp());
            } else {
                preparedStatement.setLong(1, user.getId());
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setBytes(5, user.getPhoto());
                preparedStatement.setString(6, user.getRole());
                preparedStatement.setBoolean(7, user.getEnabled());
                preparedStatement.setString(8, user.getTimestamp());
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String QUERY = "UPDATE users SET username = ?, password = ?, email = ?, photo = ?, enabled = ?, " +
                "time_stamp = ? WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setBytes(4, user.getPhoto());
            preparedStatement.setBoolean(5, user.getEnabled());
            preparedStatement.setString(6, user.getTimestamp());
            preparedStatement.setLong(7, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long userId) {
        String QUERY = "DELETE FROM users WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByUsername(String username) {
        User user = null;
        String QUERY = "SELECT * FROM users WHERE username = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getBytes("photo"),
                    resultSet.getString("role"),
                    resultSet.getBoolean("enabled"),
                    resultSet.getString("time_stamp")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Boolean usernameAlreadyExist(String username) {
        String QUERY = "SELECT username FROM users WHERE username = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            return resultSet.getString("username").equals(username);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean emailAlreadyExist(String email) {
        String QUERY = "SELECT email FROM users WHERE email = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            return resultSet.getString("email").equals(email);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public User getByEmail(String email) {
        User user = null;
        String QUERY = "SELECT * FROM users WHERE email = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getBytes("photo"),
                    resultSet.getString("role"),
                    resultSet.getBoolean("enabled"),
                    resultSet.getString("time_stamp")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getById(Long userId) {
        String QUERY = "SELECT * FROM users WHERE id = ?";
        User user = null;

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getBytes("photo"),
                    resultSet.getString("role"),
                    resultSet.getBoolean("enabled"),
                    resultSet.getString("time_stamp")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
