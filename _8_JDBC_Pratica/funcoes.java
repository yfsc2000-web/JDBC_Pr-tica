package _8_JDBC_Pratica;

import java.sql.*;

public class funcoes {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/aviao";
        String user = "root";
        String password = "";

        String sqlInsert="INSERT INTO passageiro(nome) VALUES (?)";
        String sqlUpdate="UPDATE classe_economica SET numero_assento=? WHERE id_economica=?";
        String sqlDelete="DELETE FROM classe_economica WHERE id_economica=?";
        String sqlSelect="SELECT * FROM classe_executiva WHERE id_executiva=?";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)){
            stmtInsert.setString(1,"Rebeca");

            int linha = stmtInsert.executeUpdate();

            System.out.println("Nome inserido");
            System.out.println(linha);
        }catch (SQLException e ){
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)){
            stmtUpdate.setString(1,"B12");
            stmtUpdate.setInt(2,456);

            int linha = stmtUpdate.executeUpdate();

            System.out.println("Assento e ID adicionados");
            System.out.println(linha);

        }catch (SQLException e ){
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete)){

            stmtDelete.setInt(1,34577);

            int linha = stmtDelete.executeUpdate();

            System.out.println("ID deletado");
            System.out.println(linha);
        }catch (SQLException e){
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)){

            stmtSelect.setInt(1,637483);
            ResultSet rs=stmtSelect.executeQuery();
            while (rs.next()){
                System.out.println("O ID será");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
