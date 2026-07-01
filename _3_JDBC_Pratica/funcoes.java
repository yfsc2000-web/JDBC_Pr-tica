package _3_JDBC_Pratica;


import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class funcoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sqlInsert = "INSERT INTO clinica(cpf,nome,especialidade,horario,consulta) VALUES (?,?,?,?,?)";
        String sqlUpdate = "UPDATE clinica SET nome = ? WHERE cpf = ?";
        String sqlDelete = "DELETE FROM clinica WHERE cpf = ?";
        String sqlSelect = "SELECT * FROM clinica WHERE cpf = ?";


        try (Connection conn = conexao_db.getConnection();
             PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {

            System.out.print("CPF: ");
            stmtInsert.setString(1,sc.nextLine());

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Especialidade: ");
            String especialidade = sc.nextLine();

            System.out.print("Horário: ");
            String horario = sc.nextLine();

            System.out.print("Consulta: ");
            String consulta = sc.nextLine();


            stmtInsert.setString(2, nome);
            stmtInsert.setString(3, especialidade);
            stmtInsert.setString(4, horario);
            stmtInsert.setString(5, consulta);

            stmtInsert.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // UPDATE
        try (Connection conn = conexao_db.getConnection();
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {

            System.out.print("CPF para atualizar: ");
            String cpf = sc.nextLine();

            stmtUpdate.setString(1, "NovoNome");
            stmtUpdate.setString(2, cpf);

            stmtUpdate.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // SELECT
        try (Connection conn = conexao_db.getConnection();
             PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)) {

            System.out.print("CPF para pesquisar: ");
            String cpf = sc.nextLine();

            stmtSelect.setString(1, cpf);

            ResultSet rs = stmtSelect.executeQuery();

            while (rs.next()) {
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Nome: " + rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // DELETE
        try (Connection conn = conexao_db.getConnection();
             PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete)) {

            System.out.print("CPF para excluir: ");
            String cpf = sc.nextLine();

            stmtDelete.setString(1, cpf);

            stmtDelete.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}