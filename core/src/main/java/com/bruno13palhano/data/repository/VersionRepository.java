package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.ConnectionFactory;
import com.bruno13palhano.data.Repository;
import com.bruno13palhano.model.DataVersion;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class VersionRepository implements Repository<DataVersion> {
    private final Connection connection;

    public VersionRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(DataVersion data) {
        String QUERY = "REPLACE INTO version (id, name, time_stamp) VALUES (?,?,?)";

        if (data.getId() == 0L) {
            QUERY = "INSERT INTO version (name, time_stamp) VALUES (?,?)";
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            if (data.getId() == 0L) {
                preparedStatement.setString(1, data.getName());
                preparedStatement.setString(2, data.getTimestamp());
            } else {
                preparedStatement.setLong(1, data.getId());
                preparedStatement.setString(2, data.getName());
                preparedStatement.setString(3, data.getTimestamp());
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DataVersion data) {
        String QUERY = "UPDATE version SET name = ?, time_stamp = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2, data.getTimestamp());
            preparedStatement.setLong(3, data.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String QUERY = "DELETE FROM version WHERE id = ?";

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

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(
                        new DataVersion(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
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
