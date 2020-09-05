package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DB_CONNECTION_URL = "jdbc:sqlite:src/emp1.db";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_CONNECTION_URL);
    }
}
