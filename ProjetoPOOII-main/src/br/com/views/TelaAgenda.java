
package br.com.views;

import br.com.DAO.AgendaDAO;
import br.com.DTO.AgendaDTO;
import br.com.DAO.ConexaoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaAgenda extends javax.swing.JInternalFrame {
    private JTable tableAgenda;
    private JTextField txtData, txtHorario, txtDescricao;
    private JButton btnAdicionar;
    private AgendaDAO agendaDAO;

    public TelaAgenda() {
         // Obtém a conexão com o banco de dados
        Connection conn = ConexaoDAO.getConnection();
        agendaDAO = new AgendaDAO(conn); // Inicializa o DAO da agenda com a conexão
        initComponents(); // Inicializa componentes auto-gerados
  
        setClosable(true); // Define que a janela pode ser fechada
        setLayout(null); // Define o layout como nulo para posicionamento manual dos componentes

        // Configuração manual dos componentes da tela
        JLabel lblData = new JLabel("Data:");
        lblData.setBounds(20, 20, 100, 20);
        add(lblData);

        txtData = new JTextField();
        txtData.setBounds(120, 20, 150, 20);
        add(txtData);

        JLabel lblHorario = new JLabel("Horário:");
        lblHorario.setBounds(20, 50, 100, 20);
        add(lblHorario);

        txtHorario = new JTextField();
        txtHorario.setBounds(120, 50, 150, 20);
        add(txtHorario);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(20, 80, 100, 20);
        add(lblDescricao);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(120, 80, 150, 20);
        add(txtDescricao);

        // Botão Adicionar
        btnAdicionar = new JButton("Adicionar Compromisso");
        btnAdicionar.setBounds(120, 120, 200, 30);
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarCompromisso();
            }
        });
        add(btnAdicionar);

        // Tabela de Compromissos
        tableAgenda = new JTable();
        JScrollPane scrollPane = new JScrollPane(tableAgenda);
        scrollPane.setBounds(20, 160, 500, 200);
        add(scrollPane);

        // Configurações da janela
        setSize(600, 400);
        setVisible(true);

        // Atualizar a tabela ao inicializar a tela
        atualizarTabela();
    }
  // Método para adicionar um novo compromisso
    private void adicionarCompromisso() {
         // Cria um novo objeto AgendaDTO e define seus atributos com os dados informados pelo usuário
        AgendaDTO agenda = new AgendaDTO();
        agenda.setData(txtData.getText());
        agenda.setHorario(txtHorario.getText());
        agenda.setDescricao(txtDescricao.getText());
        // Para simplificação, definindo ID do cliente fixo por agora
        agenda.setIdCliente(1);

        if (agendaDAO.adicionarCompromisso(agenda)) {
            JOptionPane.showMessageDialog(this, "Compromisso adicionado com sucesso!");
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar compromisso.");
        }
    }
// Método para atualizar a tabela de compromissos
    private void atualizarTabela() {
        List<AgendaDTO> compromissos = agendaDAO.listarCompromissos();
        String[] colunas = {"ID", "Data", "Horário", "Descrição", "Cliente"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (AgendaDTO agenda : compromissos) {
            Object[] linha = {agenda.getId(), agenda.getData(), agenda.getHorario(), agenda.getDescricao(), agenda.getIdCliente()};
            model.addRow(linha);
        
        
        tableAgenda.setModel(model);
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
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
 

