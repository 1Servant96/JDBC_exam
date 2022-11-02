package peaksoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfiguration {
    private static final String username = "postgres";
    private static final String password = "1234";
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


//    public Connection getConnection() {        return connection;    }
//    public final Connection connection;
//    public JDBCConfig() throws SQLException {        connection = DriverManager.getConnection(                "jdbc:postgresql://localhost:5432/java7",                "postgres",                "1234"        );    }
//    public Connection getConnection() {        return connection;    }
}
