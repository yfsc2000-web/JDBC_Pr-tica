package _5_JDBC_Pratica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao_db {
    public static void main(String[] args)throws SQLException {

        String url = "jdbc:mysql://localhost:3306/restaurante";
        String user = "root";
        String password = "";


        try (Connection conexao = DriverManager.getConnection(url, user, null)) {
            System.out.println("Conexão realizada com sucesso!");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
