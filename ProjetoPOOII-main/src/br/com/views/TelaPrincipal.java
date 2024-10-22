
package br.com.views;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import br.com.views.TelaCadastroClientes;


public class TelaPrincipal extends javax.swing.JFrame {

    
    public TelaPrincipal() {
        initComponents();
        
         jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
    jMenuItem2.setText("Cliente");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem2ActionPerformed(evt); 
            
            
        }

    });
    MenuCadastro.add(jMenuItem2);
    }
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
    // Certifique-se de que a classe TelaCadastroClientes existe e está importada corretamente.
    TelaCadastroClientes telaClientes = new TelaCadastroClientes();
    telaClientes.setVisible(true);
    Desktop.add(telaClientes);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        lblUsuarioPrincipal = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        subMenuUsuarios = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        MenuRel = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Desktop.setPreferredSize(new java.awt.Dimension(604, 500));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblUsuarioPrincipal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuarioPrincipal.setText("Usuário");

        lblData.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblData.setText("Data");

        MenuCadastro.setText("Cadastro");

        subMenuUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        subMenuUsuarios.setText("Usuários");
        subMenuUsuarios.setEnabled(false);
        subMenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuUsuariosActionPerformed(evt);
            }
        });
        MenuCadastro.add(subMenuUsuarios);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Cliente");
        MenuCadastro.add(jMenuItem2);

        Menu.add(MenuCadastro);

        MenuRel.setText("Relatório");
        MenuRel.setEnabled(false);
        Menu.add(MenuRel);

        jMenu3.setText("Ajuda");

        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        Menu.add(jMenu3);

        jMenu4.setText("Opções");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        Menu.add(jMenu4);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuarioPrincipal)
                    .addComponent(lblData))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuarioPrincipal)
                .addGap(18, 18, 18)
                .addComponent(lblData)
                .addContainerGap(535, Short.MAX_VALUE))
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(818, 668));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void subMenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuUsuariosActionPerformed
        // abrir dentro do painel a tela usuarios
        TelaUsuario tusuario = new TelaUsuario();
        tusuario.setVisible(true);
        Desktop.add(tusuario);
    }//GEN-LAST:event_subMenuUsuariosActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Data atual
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
        
    }//GEN-LAST:event_formWindowActivated

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        int sair = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair","Atenção",JOptionPane.YES_NO_OPTION);
        if(sair == JOptionPane.YES_OPTION){
            System.exit(sair);
            
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Chamando a tela Sobre
        TelaSobre tsobre = new TelaSobre();
        tsobre.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItemAgendaActionPerformed(java.awt.event.ActionEvent evt) {                                           
    TelaAgenda telaAgenda = new TelaAgenda();
    telaAgenda.setVisible(true);
    Desktop.add(telaAgenda);
}
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Menu;
    public static javax.swing.JMenu MenuCadastro;
    public static javax.swing.JMenu MenuRel;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuarioPrincipal;
    public static javax.swing.JMenuItem subMenuUsuarios;
    // End of variables declaration//GEN-END:variables
}
