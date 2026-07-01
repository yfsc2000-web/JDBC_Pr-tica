package _4_JDBC_Pratica;

import java.sql.*;

public class funcoes {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Estacionamento";
        String user = "root";
        String password = "";

        String sqlInsert="INSERT INTO Carros(marca) VALUES (?)";
        String sqlUpdate="UPDATE Motos SET cor=? WHERE id_moto=?";
        String sqlDelete="DELETE FROM Motos WHERE  id_moto=?";
        String sqlSelect="SELECT * FROM Pagamento WHERE id_pagamento=?";


        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)){
            stmtInsert.setString(1,"Fusca");

            int linha = stmtInsert.executeUpdate();

            System.out.println("Marca inserido");
            System.out.println(linha);
        }catch (SQLException e ){
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)){
            stmtUpdate.setString(1,"vermelho");
            stmtUpdate.setInt(2,45697);

            int linha = stmtUpdate.executeUpdate();

            System.out.println("Placa e ID adicionados");
            System.out.println(linha);

        }catch (SQLException e ){
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete)){

            stmtDelete.setInt(1,7854692);

            int linha = stmtDelete.executeUpdate();

            System.out.println("ID deletado");
            System.out.println(linha);
        }catch (SQLException e){
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)){

            stmtSelect.setInt(1,6345);
            ResultSet rs=stmtSelect.executeQuery();
            while (rs.next()){
                System.out.println("O ID do pagamento será: ");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
