
package br.com.views;


import java.sql.*;
import br.com.DAO.ConexaoDAO;
import br.com.DAO.UsuarioDAO;
import br.com.DTO.UsuarioDTO;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    
    public TelaUsuario() {
        initComponents();
        conexao = ConexaoDAO.getConnection();
        UsuarioDAO ojbUsuarioDAO = new UsuarioDAO();
        ojbUsuarioDAO.pesquisaAuto();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdUsu = new javax.swing.JTextField();
        txtNomeUsu = new javax.swing.JTextField();
        txtLoginUsu = new javax.swing.JTextField();
        txtSenhaUsu = new javax.swing.JTextField();
        cboPerfilUsu = new javax.swing.JComboBox<>();
        btnUsuCreate = new javax.swing.JButton();
        btnUsuread = new javax.swing.JButton();
        btnUsuUpdate = new javax.swing.JButton();
        btnUsuDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbUsuarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(604, 500));

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel3.setText("Login");

        jLabel4.setText("Senha");

        jLabel5.setText("Perfil");

        txtIdUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUsuActionPerformed(evt);
            }
        });

        txtLoginUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginUsuActionPerformed(evt);
            }
        });

        cboPerfilUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        btnUsuCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/person_add.png"))); // NOI18N
        btnUsuCreate.setToolTipText("Adicionar");
        btnUsuCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuCreateActionPerformed(evt);
            }
        });

        btnUsuread.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/search.png"))); // NOI18N
        btnUsuread.setToolTipText("Pesquisar");
        btnUsuread.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsureadActionPerformed(evt);
            }
        });

        btnUsuUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/update.png"))); // NOI18N
        btnUsuUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuUpdateActionPerformed(evt);
            }
        });

        btnUsuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete_.png"))); // NOI18N
        btnUsuDelete.setToolTipText("Excluir");
        btnUsuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuDeleteActionPerformed(evt);
            }
        });

        TbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Login", "Senha", "Perfil"
            }
        ));
        TbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbUsuarios);

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btnUsuread, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSenhaUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(162, 162, 162))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNomeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtIdUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLoginUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cboPerfilUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnUsuDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLoginUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSenhaUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPerfilUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsuread, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 604, 652);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUsuActionPerformed

    private void txtLoginUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginUsuActionPerformed

    private void btnUsuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCreateActionPerformed
        int id_usuario = Integer.parseInt(txtIdUsu.getText());
        String nome_usuario = txtNomeUsu.getText();
        String login_usuario = txtLoginUsu.getText();
        String senha_usuario = txtSenhaUsu.getText();
        String perfil_usuario = cboPerfilUsu.getSelectedItem().toString();

        UsuarioDTO objusuarioDTO = new UsuarioDTO();
        objusuarioDTO.setId_usuario(id_usuario);
        objusuarioDTO.setNome_usuario(nome_usuario);
        objusuarioDTO.setLogin_usuario(login_usuario);
        objusuarioDTO.setSenha_usuario(senha_usuario);
        objusuarioDTO.setPerfil_usuario(perfil_usuario);

        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.inserirUsuario(objusuarioDTO);
    }//GEN-LAST:event_btnUsuCreateActionPerformed

    private void btnUsuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuDeleteActionPerformed
        //Botão Deletar
        int id_usuario = Integer.parseInt(txtIdUsu.getText());
        UsuarioDTO objusuarioDTO = new UsuarioDTO();
        objusuarioDTO.setId_usuario(id_usuario);
        
        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.deletar(objusuarioDTO);
    }//GEN-LAST:event_btnUsuDeleteActionPerformed

    private void btnUsureadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsureadActionPerformed
        //Botão Pesquisar
        int id_usuario = Integer.parseInt(txtIdUsu.getText());
        String nome_usuario = txtNomeUsu.getText();
        String login_usuario = txtLoginUsu.getText();
        String senha_usuario = txtSenhaUsu.getText();
        String perfil_usuario = cboPerfilUsu.getSelectedItem().toString();

        UsuarioDTO objusuarioDTO = new UsuarioDTO();
        objusuarioDTO.setId_usuario(id_usuario);
        objusuarioDTO.setNome_usuario(nome_usuario);
        objusuarioDTO.setLogin_usuario(login_usuario);
        objusuarioDTO.setSenha_usuario(senha_usuario);
        objusuarioDTO.setPerfil_usuario(perfil_usuario);

        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.pesquisar(objusuarioDTO);
    }//GEN-LAST:event_btnUsureadActionPerformed

    private void btnUsuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuUpdateActionPerformed
        // Botão Editar
        int id_usuario = Integer.parseInt(txtIdUsu.getText());
        String nome_usuario = txtNomeUsu.getText();
        String login_usuario = txtLoginUsu.getText();
        String senha_usuario = txtSenhaUsu.getText();
        String perfil_usuario = cboPerfilUsu.getSelectedItem().toString();

        UsuarioDTO objusuarioDTO = new UsuarioDTO();
        objusuarioDTO.setId_usuario(id_usuario);
        objusuarioDTO.setNome_usuario(nome_usuario);
        objusuarioDTO.setLogin_usuario(login_usuario);
        objusuarioDTO.setSenha_usuario(senha_usuario);
        objusuarioDTO.setPerfil_usuario(perfil_usuario);

        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.editar(objusuarioDTO);
    }//GEN-LAST:event_btnUsuUpdateActionPerformed

    private void TbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbUsuariosMouseClicked
        //Busca itens da tabela para os campos do formulário
        int linhaSel = TbUsuarios.getSelectedRow();
        if(linhaSel != -1 ){
            String id_usuario = TbUsuarios.getValueAt(linhaSel, 0).toString();
            String nome_usuario = TbUsuarios.getValueAt(linhaSel, 1).toString();
            String login_usuario = TbUsuarios.getValueAt(linhaSel, 2).toString();
            String senha_usuario = TbUsuarios.getValueAt(linhaSel, 3).toString();
            String perfil_usuario = TbUsuarios.getValueAt(linhaSel, 4).toString();
            
            txtIdUsu.setText(id_usuario);
            txtNomeUsu.setText(nome_usuario);
            txtLoginUsu.setText(login_usuario);
            txtSenhaUsu.setText(senha_usuario);
            cboPerfilUsu.setSelectedItem(perfil_usuario);
        }
    }//GEN-LAST:event_TbUsuariosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Botão limpar campos
        UsuarioDAO objusuarioDAO = new UsuarioDAO();
        objusuarioDAO.limparCampos();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TbUsuarios;
    private javax.swing.JButton btnUsuCreate;
    private javax.swing.JButton btnUsuDelete;
    private javax.swing.JButton btnUsuUpdate;
    private javax.swing.JButton btnUsuread;
    public static javax.swing.JComboBox<String> cboPerfilUsu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField txtIdUsu;
    public static javax.swing.JTextField txtLoginUsu;
    public static javax.swing.JTextField txtNomeUsu;
    public static javax.swing.JTextField txtSenhaUsu;
    // End of variables declaration//GEN-END:variables
}
