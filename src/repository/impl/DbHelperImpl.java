package repository.impl;

import repository.DPHelper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelperImpl implements DPHelper {
    @Override
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db_store",
                "postgres",
                "Nurba010909");
        return connection.prepareStatement(sql);
    }
}
