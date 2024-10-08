
package br.com.Views;

import br.com.DAO.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class TelaUsuario extends javax.swing.JPanel {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public TelaUsuario() {
        initComponents();
        conexao = ConexaoDAO.conector();
    }
 public void pesquisa(){
        String sql = "select * from tbusuarios where id_usuario = ?";
            try{
                pst = conexao.prepareStatement (sql);
                pst.setString(1, txtIdUsu.getText());
                rs = pst.executeQuery();
                if(rs.next()) {
                    txtNomeUsu.setText(rs.getString(2));
                } else {
                    JOptionPane.showMessageDialog(null, "usuario não cadastrado!");
                    limpar();
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
