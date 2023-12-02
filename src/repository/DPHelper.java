package repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DPHelper {
    PreparedStatement getPreparedStatement(String sql) throws SQLException;
}
