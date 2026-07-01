package _7_JDBC_Pratica;

import java.sql.*;

public class funcoes {
    public static void main(String[] args)  throws SQLException {

        String url = "jdbc:mysql://localhost:3306/assistir";
        String user = "root";
        String password = "";

        String sqlInsert="INSERT INTO ContaStreaming(nome_usuario) VALUES (?)";
        String sqlUpdate="UPDATE PlanoPadrao SET preco=? WHERE id_padrao=?";
        String sqlDelete="DELETE FROM PlanoPadrao WHERE id_padrao=?";
        String sqlSelect="SELECT * FROM PlanoPremium WHERE id_premium=?";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)){
            stmtInsert.setString(1,"Raissa");

            int linha= stmtInsert.executeUpdate();
            System.out.println("Nome adicionado");
            System.out.println(linha);
        }catch (SQLException e){
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)){
            stmtUpdate.setDouble(1,14.05);
            stmtUpdate.setInt(2,86495);

            int linha = stmtUpdate.executeUpdate();

            System.out.println("Dados adicionados");
            System.out.println(linha);
        }catch (SQLException e ){
            e.printStackTrace();
        }

        try  (Connection conn = DriverManager.getConnection(url,user,password);
              PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete)){
            stmtDelete.setInt(1,46598);

            int linha= stmtDelete.executeUpdate();
            System.out.println("ID deletado");
            System.out.println(linha);
        }catch (SQLException e){
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)){
            stmtSelect.setInt(1,7896);
            ResultSet rs= stmtSelect.executeQuery();
            while (rs.next()){
                System.out.println("Os IDS disponiveis serão: "+rs.getInt("id_premium"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
