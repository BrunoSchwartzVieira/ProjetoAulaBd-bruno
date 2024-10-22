package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import br.com.views.TelaPrincipal;
import br.com.views.TelaUsuario;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void logar(UsuarioDTO objusuarioDTO) {
        String sql = "SELECT * FROM tb_usuarios WHERE login_usuario = ? AND senha_usuario = ?";
        conexao = ConexaoDAO.getConnection();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objusuarioDTO.getLogin_usuario());
            pst.setString(2, objusuarioDTO.getSenha_usuario());
            rs = pst.executeQuery();

            if (rs.next()) {
                String perfil = rs.getString(5);

                if (perfil.equals("admin")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    principal.lblUsuarioPrincipal.setText(rs.getString(2));
                    TelaPrincipal.MenuRel.setEnabled(true);
                    TelaPrincipal.subMenuUsuarios.setEnabled(true);
                    principal.lblUsuarioPrincipal.setForeground(Color.RED);
                } else {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.lblUsuarioPrincipal.setForeground(Color.BLUE);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer login: " + e.getMessage());
        } finally {
            ConexaoDAO.closeConnection(conexao, pst, rs);
        }
    }

    public void inserirUsuario(UsuarioDTO objUsuarioDTO) {
        String sql = "INSERT INTO tb_usuarios (usuario, login_usuario, senha_usuario, perfil) VALUES (?, ?, ?, ?)";
        conexao = ConexaoDAO.getConnection();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objUsuarioDTO.getNome_usuario());
            pst.setString(2, objUsuarioDTO.getLogin_usuario());
            pst.setString(3, objUsuarioDTO.getSenha_usuario());
            pst.setString(4, objUsuarioDTO.getPerfil_usuario());
            int add = pst.executeUpdate();
            if (add > 0) {
                pesquisaAuto();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método Inserir: " + e.getMessage());
        } finally {
            ConexaoDAO.closeConnection(conexao, pst);
        }
    }

    public void pesquisar(UsuarioDTO objUsuarioDTO) {
        String sql = "SELECT * FROM tb_usuarios WHERE id_usuario = ?";
        conexao = ConexaoDAO.getConnection();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            rs = pst.executeQuery();
            if (rs.next()) {
                TelaUsuario.txtNomeUsu.setText(rs.getString("usuario"));
                TelaUsuario.txtLoginUsu.setText(rs.getString("login_usuario"));
                TelaUsuario.txtSenhaUsu.setText(rs.getString("senha_usuario"));
                TelaUsuario.cboPerfilUsu.setSelectedItem(rs.getString("perfil"));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no método Pesquisar: " + e.getMessage());
        } finally {
            ConexaoDAO.closeConnection(conexao, pst, rs);
        }
    }

    public void pesquisaAuto() {
        String sql = "SELECT * FROM tb_usuarios";
        conexao = ConexaoDAO.getConnection();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaUsuario.TbUsuarios.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("usuario");
                String login = rs.getString("login_usuario");
                String senha = rs.getString("senha_usuario");
                String perfil = rs.getString("perfil");
                model.addRow(new Object[]{id, nome, login, senha, perfil});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no método Pesquisa Automática: " + e.getMessage());
        } finally {
            ConexaoDAO.closeConnection(conexao, pst, rs);
        }
    }

    public void editar(UsuarioDTO objUsuarioDTO) {
        String sql = "UPDATE tb_usuarios SET usuario = ?, login_usuario = ?, senha_usuario = ?, perfil = ? WHERE id_usuario = ?";
        conexao = ConexaoDAO.getConnection();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objUsuarioDTO.getNome_usuario());
            pst.setString(2, objUsuarioDTO.getLogin_usuario());
            pst.setString(3, objUsuarioDTO.getSenha_usuario());
            pst.setString(4, objUsuarioDTO.getPerfil_usuario());
            pst.setInt(5, objUsuarioDTO.getId_usuario());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
                pesquisaAuto();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no método Editar: " + e.getMessage());
        } finally {
            ConexaoDAO.closeConnection(conexao, pst);
        }
    }

    public void deletar(UsuarioDTO objUsuarioDTO) {
        String sql = "DELETE FROM tb_usuarios WHERE id_usuario = ?";
        conexao = ConexaoDAO.getConnection();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
                pesquisaAuto();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no método Deletar: " + e.getMessage());
        } finally {
            ConexaoDAO.closeConnection(conexao, pst);
        }
    }

    public void limparCampos() {
        TelaUsuario.txtIdUsu.setText(null);
        TelaUsuario.txtLoginUsu.setText(null);
        TelaUsuario.txtNomeUsu.setText(null);
        TelaUsuario.txtSenhaUsu.setText(null);
        TelaUsuario.cboPerfilUsu.setSelectedItem("user"); // Ajustar o valor padrão para 'user'
    }
}
