package br.com.DAO;

import br.com.DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Método para inserir cliente
    public boolean inserirCliente(ClienteDTO cliente) {
    boolean resultado = false;
    String sql = "INSERT INTO tb_clientes (nome, endereco, telefone, email, cpf_cnpj) VALUES (?, ?, ?, ?, ?)";
    conexao = ConexaoDAO.getConnection();

    try {
        // Prepara a instrução SQL para inserção
        pst = conexao.prepareStatement(sql);
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getEndereco());
        pst.setString(3, cliente.getTelefone());
        pst.setString(4, cliente.getEmail());
        pst.setString(5, cliente.getCpfCnpj());
 // Executa a inserção e verifica se foi bem-sucedida
        int linhasAfetadas = pst.executeUpdate();
        resultado = linhasAfetadas > 0;
    } catch (Exception e) {
        // Exibe uma mensagem de erro se ocorrer uma exceção
        JOptionPane.showMessageDialog(null, "Erro ao inserir cliente: " + e.getMessage());
    } finally {
         // Fecha a conexão com o banco de dados
        ConexaoDAO.closeConnection(conexao, pst);
    }

    return resultado; // Retorna 'true' se a inserção foi bem-sucedida
}

    // Método para pesquisar cliente
    public ClienteDTO pesquisarCliente(int id) {
        ClienteDTO cliente = null;
        String sql = "SELECT * FROM tb_clientes WHERE id_cliente = ?";
        conexao = ConexaoDAO.getConnection();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
// Verifica se encontrou um cliente e preenche o objeto ClienteDTO
            if (rs.next()) {
                cliente = new ClienteDTO();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpfCnpj(rs.getString("cpf_cnpj"));
            }

            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar cliente: " + e.getMessage());
        }

        return cliente; // Retorna o cliente encontrado ou 'null' se não encontrado
    }

    // Método para atualizar cliente
    public boolean atualizarCliente(ClienteDTO cliente) {
        boolean resultado = false;
        String sql = "UPDATE tb_clientes SET nome = ?, endereco = ?, telefone = ?, email = ?, cpf_cnpj = ? WHERE id_cliente = ?";
        conexao = ConexaoDAO.getConnection();

        try {
             // Prepara a instrução SQL para atualização
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEndereco());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEmail());
            pst.setString(5, cliente.getCpfCnpj());
            pst.setInt(6, cliente.getId());
// Executa a atualização e verifica se foi bem-sucedida
            int linhasAfetadas = pst.executeUpdate();
            resultado = linhasAfetadas > 0; // Retorna true se alguma linha foi afetada

            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + e.getMessage());
        }

        return resultado; // Retorna 'true' se a atualização foi bem-sucedida
    }

    // Método para deletar cliente
    public boolean deletarCliente(int id) {
        boolean resultado = false;
        String sql = "DELETE FROM tb_clientes WHERE id_cliente = ?";
        conexao = ConexaoDAO.getConnection();

        try {
             // Prepara a instrução SQL para exclusão
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            int linhasAfetadas = pst.executeUpdate();
            resultado = linhasAfetadas > 0; // Retorna true se alguma linha foi afetada

            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + e.getMessage());
        }

        return resultado; // Retorna 'true' se a exclusão foi bem-sucedida
    }
}
