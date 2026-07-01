package _6_JDBC_Pratica;

import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class funcoes {
    public static void main(String[] args)  throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hospedagem";
        String user = "root";
        String password = "";

        String sqlInsert="INSERT INTO Cadastro(nome) VALUES (?)";
        String sqlUpdate="UPDATE Quartos SET numero_quarto=? WHERE id_quarto=?";
        String sqlDelete="DELETE FROM Quartos WHERE  id_quarto=?";
        String sqlSelect="SELECT * FROM Pagamento WHERE id_pagamento=?";


        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)){
            stmtInsert.setString(1,"Renato");

            int linha = stmtInsert.executeUpdate();
            System.out.println("Nome inserido");
            System.out.println(linha);
        }catch (SQLException e){
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)){
            stmtUpdate.setInt(1,789);
            stmtUpdate.setInt(2,568);

            int linha= stmtUpdate.executeUpdate();
            System.out.println("Número do quarto e ID adicionados");
            System.out.println(linha);
        }catch (SQLException e){
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete)){
            stmtDelete.setInt(1,3456);

            int linha= stmtDelete.executeUpdate();
            System.out.println("ID deletado");
            System.out.println(linha);
        }catch (SQLException e){
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)){
            stmtSelect.setInt(1,47895);
            ResultSet rs = stmtSelect.executeQuery();

            while (rs.next()){
                System.out.println("Os IDS disponiveis serão: "+rs.getString("id_pagamento"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
