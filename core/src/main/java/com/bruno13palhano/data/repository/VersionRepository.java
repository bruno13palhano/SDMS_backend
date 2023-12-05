package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.model.DataVersion;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class VersionRepository implements Repository<DataVersion> {
    @Override
    public void insert(DataVersion data) {
        String QUERY = "INSERT OR REPLACE INTO version (id, name, time_stamp) VALUES (?,?,?)";

        if (data.getId() == 0L) {
            QUERY = "INSERT INTO version (name, time_stamp) VALUES (?,?)";
        }

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (data.getId() == 0L) {
                preparedStatement.setString(1, data.getName());
                preparedStatement.setTimestamp(2, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setString(2, data.getName());
                preparedStatement.setTimestamp(3, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DataVersion data) {
        String QUERY = "UPDATE version SET name = ?, time_stamp = ? WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, data.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(data.getTimestamp().toLocalDateTime()));
            preparedStatement.setLong(3, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM version WHERE id = ?";

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
    public List<DataVersion> getAll() {
        List<DataVersion> result = new ArrayList<>();
        String QUERY = "SELECT * FROM version";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(
                        new DataVersion(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getObject("time_stamp", OffsetDateTime.class)
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
