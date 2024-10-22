
package br.com.DAO;

import br.com.DTO.AgendaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {
    // Conexão com o banco de dados
     private Connection conn;

    public AgendaDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para adicionar compromisso
    public boolean adicionarCompromisso(AgendaDTO agenda) {
        // SQL para inserir um novo compromisso
        String sql = "INSERT INTO agenda (data, horario, descricao, id_cliente) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Configurando os parâmetros do SQL com os valores do objeto 'AgendaDTO'
            stmt.setString(1, agenda.getData());
            stmt.setString(2, agenda.getHorario());
            stmt.setString(3, agenda.getDescricao());
            stmt.setInt(4, agenda.getIdCliente());
            // Executando o comando SQL para inserir o registro
            stmt.executeUpdate();
            return true; // Retorna 'true' se a operação for bem-sucedida
        } catch (Exception e) {
            e.printStackTrace(); // Exibe erros, se houver
            return false; // Retorna 'false' se ocorrer algum erro
        }
    }

    // Método para listar compromissos
    public List<AgendaDTO> listarCompromissos() {
        // Lista para armazenar os compromissos recuperados do banco de dados
        List<AgendaDTO> compromissos = new ArrayList<>();
        // SQL para selecionar todos os compromissos da tabela 'agenda'
        String sql = "SELECT * FROM agenda";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            // Itera sobre o resultado da consulta e cria objetos 'AgendaDTO'
            while (rs.next()) {
                AgendaDTO agenda = new AgendaDTO();
                agenda.setId(rs.getInt("id")); // ID do compromisso
                agenda.setData(rs.getString("data")); // Data do compromisso
                agenda.setHorario(rs.getString("horario")); // Horário do compromisso
                agenda.setDescricao(rs.getString("descricao")); // Descrição
                agenda.setIdCliente(rs.getInt("id_cliente")); // ID do cliente associado
                 // Adiciona o objeto 'AgendaDTO' à lista
                compromissos.add(agenda);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Exibe erros, se houver
        }
        return compromissos; // Retorna a lista de compromissos
    }

}
