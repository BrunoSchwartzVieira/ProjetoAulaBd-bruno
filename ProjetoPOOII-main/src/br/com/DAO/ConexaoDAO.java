package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {
// Método para obter uma conexão com o banco de dados
    public static Connection getConnection() {
        Connection conexao = null;
// Informações para a conexão MySQL
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sistema_agenda";
        String user = "root";
        String password = "root";

        try {
            // Carrega o driver do MySQL
            Class.forName(driver);
            // Estabelece a conexão
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Exibe mensagem de erro caso ocorra um problema com a conexão
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Exibe mensagem de erro caso o driver não seja encontrado
            JOptionPane.showMessageDialog(null, "Driver não encontrado: " + e.getMessage());
        }

        return conexao; // Retorna a conexão estabelecida ou 'null' em caso de falha
    }

    // Método para fechar a conexão
    public static void closeConnection(Connection conn, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
        }
    }
// Sobrecarga do método para fechar conexão e PreparedStatement
    public static void closeConnection(Connection conn, PreparedStatement pst) {
        closeConnection(conn, pst, null);
    }
// Sobrecarga do método para fechar apenas a conexão
    public static void closeConnection(Connection conn) {
        closeConnection(conn, null, null);
    }
}
