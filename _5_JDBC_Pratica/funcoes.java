package _5_JDBC_Pratica;

import java.sql.*;

public class funcoes {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/restaurante";
        String user = "root";
        String password = "";

        String sqlInsert="INSERT INTO login(id) VALUES (?)";
        String sqlUpdate="UPDATE pagamento SET forma_pagamento =? WHERE id=?";
        String sqlDelete="DELETE FROM pagamento WHERE id=?";
        String sqlSelect="SELECT * FROM produto WHERE id=?";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
            stmtInsert.setInt(1, 124);

            int linha = stmtInsert.executeUpdate();

            System.out.println("id inserido");
            System.out.println(linha);

        }catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
            stmtUpdate.setString(1, "Crédito");
            stmtUpdate.setInt(2, 335);

            int linha = stmtUpdate.executeUpdate();

            System.out.println("Forma de pagamento e id adicionados");
            System.out.println(linha);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete)){

            stmtDelete.setInt(1,76895);

            int linha = stmtDelete.executeUpdate();

            System.out.println("ID deletado");
            System.out.println(linha);

        }catch (SQLException e) {
            e.printStackTrace();

        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)) {

            stmtSelect.setInt(1, 456371834);
            ResultSet rs = stmtSelect.executeQuery();
            while (rs.next()) {
                System.out.println("O ID será:");
            }
        } catch (SQLException e){
            e.printStackTrace();




        }
    }
}


