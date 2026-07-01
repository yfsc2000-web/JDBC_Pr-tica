package _2_JDBC_Pratica;

import java.sql.*;

public class funcoes {
    static void main() {
        String url = "jdbc:mysql://localhost:3306/escola";
        String user = "root";
        String password = null;

        String sqlInsert = "INSERT INTO livro(codigo_livro) Values (?)";
        String sqlUpdate = "UPDATE livro SET codigo_livro =? WHERE disponivel=?";
        String sqlDelete = "DELETE FROM escola  WHERE id=?";
        String sqlSelect = "SELECT*FROM matricula WHERE numero_matricula = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
            stmtInsert.setInt(1, 4569);

            int linhas = stmtInsert.executeUpdate();

            System.out.println("Linhas" + linhas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {

            stmtUpdate.setInt(1, 464);
            stmtUpdate.setString(2, "sim");

           int linhas=stmtUpdate.executeUpdate();

            System.out.println("Valores mudados");
            System.out.println(linhas);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete)) {
            stmtDelete.setInt(1, 23433);

            int linha = stmtDelete.executeUpdate();

            System.out.println("ID deletado");
            System.out.println(linha);


        } catch (SQLException e) {
            e.printStackTrace();
        }try (Connection conn = DriverManager.getConnection(url, user, password);
              PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)) {
            stmtSelect.setInt(1,45);

            ResultSet rs=stmtSelect.executeQuery();
            while (rs.next()){
                System.out.println("O número da matricula selecionado será "+rs.getString("matricula"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
