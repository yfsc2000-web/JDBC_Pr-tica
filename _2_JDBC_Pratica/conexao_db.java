package _2_JDBC_Pratica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao_db {public static Connection getConnection() throws SQLException {
        try {

            String url = "jdbc:mysql://localhost:3306/escola";
            String user ="root";
            String password = null;

            return DriverManager.getConnection(url, user, null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

