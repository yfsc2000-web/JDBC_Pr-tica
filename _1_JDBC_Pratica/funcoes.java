package _1_JDBC_Pratica;

import java.sql.*;

public class funcoes {
    static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/delivery";
        String user = "root";
        String password = null;

        String sqlselect = "SELECT*FROM login WHERE email = ?";
        String sqlInsert = "INSERT INTO produto(nome) Values (?)";
        String sqlUpdate = "UPDATE produto SET nome =? WHERE id=?";
        String sqlDelete = "DELETE FROM produto WHERE id=?";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmt= conn.prepareStatement(sqlselect)){
            stmt.setString(1 ,"yasmin@gmail");
            ResultSet rs=stmt.executeQuery();
            while (rs.next()){
                System.out.println("O email será"+rs.getString("email"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtinsert= conn.prepareStatement(sqlInsert)){
            stmtinsert.setString(1,"wepink");


            int linhas = stmtinsert.executeUpdate();

            System.out.println("Produto inserido");
            System.out.println(linhas);

        }catch (SQLException e){
            e.printStackTrace();
        }


        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmt= conn.prepareStatement(sqlUpdate)){
            stmt.setString(1,"Emilly");
            stmt.setInt(2,24);

            int linhas = stmt.executeUpdate();

            System.out.println("Produto atualizado");
            System.out.println(linhas);

        }catch (SQLException e){
            e.printStackTrace();
        }


        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmt= conn.prepareStatement(sqlDelete)){
            stmt.setInt(1,234);

            int linhas = stmt.executeUpdate();

            System.out.println("Produto deletado");
            System.out.println(linhas);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
