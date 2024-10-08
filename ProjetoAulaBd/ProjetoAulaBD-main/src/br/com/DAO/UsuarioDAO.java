
package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class UsuarioDAO {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void inserirUsuario (UsuarioDTO objUsuarioDTO) {
        String sql = "insert into tb_usuarios (id_usuario, usuario, login, senha, perfil)"
                + " values (?, ?, ?, ?, ?)";
        conexao = new ConexaoDAO().conector();
        
            try {
                
                pst = conexao.prepareStatement(sql);
                
                pst.setInt(1, objUsuarioDTO.getId_usuario());
                pst.setInt(2, objUsuarioDTO.getNome_usuario());
                pst.setInt(3, objUsuarioDTO.getLogin_usuario());
                pst.setInt(4, objUsuarioDTO.getSenha_usuario());
                pst.setInt(5, objUsuarioDTO.getPerfil_usuario());
                
                pst.execute();
                pst.close();
                
            }
            
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, " UsuarioDAO" + e);
            }
    
    
}
}