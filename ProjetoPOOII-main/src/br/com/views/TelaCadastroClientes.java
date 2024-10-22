package br.com.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import br.com.DTO.ClienteDTO;
import br.com.DAO.ClienteDAO;
import javax.swing.JOptionPane;

// Construtor da classe que configura a tela e seus componentes
public class TelaCadastroClientes extends JFrame {

    private JLabel lblNome, lblEndereco, lblTelefone, lblEmail, lblCpfCnpj;
    private JTextField txtNome, txtEndereco, txtTelefone, txtEmail, txtCpfCnpj;
    private JButton btnInserir, btnEditar, btnExcluir, btnLimpar;

    public TelaCadastroClientes() {
        // Configurações da janela
        setTitle("Cadastro de Clientes");
        setSize(400, 350);
        setLayout(null);

        // Componentes da interface
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(130, 20, 200, 25);
        add(txtNome);

        lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(20, 60, 100, 25);
        add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(130, 60, 200, 25);
        add(txtEndereco);

        lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 100, 100, 25);
        add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(130, 100, 200, 25);
        add(txtTelefone);

        lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(20, 140, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(130, 140, 200, 25);
        add(txtEmail);

        lblCpfCnpj = new JLabel("CPF/CNPJ:");
        lblCpfCnpj.setBounds(20, 180, 100, 25);
        add(lblCpfCnpj);

        txtCpfCnpj = new JTextField();
        txtCpfCnpj.setBounds(130, 180, 200, 25);
        add(txtCpfCnpj);

        // Botões
        btnInserir = new JButton("Inserir");
        btnInserir.setBounds(20, 250, 80, 30);
        add(btnInserir);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(110, 250, 80, 30);
        add(btnEditar);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(200, 250, 80, 30);
        add(btnExcluir);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(290, 250, 80, 30);
        add(btnLimpar);

        // Ações dos botões
        btnInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 // Cria um objeto ClienteDTO e define os valores a partir dos campos de texto
                ClienteDTO cliente = new ClienteDTO();
                cliente.setNome(txtNome.getText());
                cliente.setEndereco(txtEndereco.getText());
                cliente.setTelefone(txtTelefone.getText());
                cliente.setEmail(txtEmail.getText());
                cliente.setCpfCnpj(txtCpfCnpj.getText());
// Chama o método para inserir o cliente no banco de dados
                ClienteDAO dao = new ClienteDAO();
                dao.inserirCliente(cliente);
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chama o método para editar o cliente
                editarCliente();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 // Chama o método para excluir o cliente
                excluirCliente();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chama o método para limpar os campos de texto
                limparCampos();
            }
        });

        // Configurações finais da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar a janela na tela
    }
 // Método para editar informações de um cliente
    private void editarCliente() {
        String idStr = JOptionPane.showInputDialog(this, "Informe o ID do cliente que deseja editar:");
        if (idStr != null && !idStr.trim().isEmpty()) {
            int id = Integer.parseInt(idStr);

            ClienteDAO dao = new ClienteDAO();
            ClienteDTO cliente = dao.pesquisarCliente(id);
// Preenche os campos de texto com os dados do cliente encontrado
            if (cliente != null) {
                txtNome.setText(cliente.getNome());
                txtEndereco.setText(cliente.getEndereco());
                txtTelefone.setText(cliente.getTelefone());
                txtEmail.setText(cliente.getEmail());
                txtCpfCnpj.setText(cliente.getCpfCnpj());
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
            }
        }
    }
// Método para excluir um cliente a partir do ID fornecido
    private void excluirCliente() {
        String idStr = JOptionPane.showInputDialog(this, "Informe o ID do cliente que deseja excluir:");

        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                if (id > 0) {
                    int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o cliente com ID " + id + "?", "Confirmação", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        ClienteDAO dao = new ClienteDAO();
                        boolean resultado = dao.deletarCliente(id);

                        if (resultado) {
                            JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
                            limparCampos();
                        } else {
                            JOptionPane.showMessageDialog(this, "Erro ao excluir cliente. Verifique se o cliente existe.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ID inválido. Por favor, insira um ID positivo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID inválido. Por favor, insira um número.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir cliente: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Operação cancelada. Nenhum ID foi inserido.");
        }
    }
// Método para limpar os campos de texto
    public void limparCampos() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtCpfCnpj.setText("");
    }
// Método principal para iniciar a aplicação
    public static void main(String[] args) {
        TelaCadastroClientes tela = new TelaCadastroClientes();
        tela.setVisible(true);
    }



@SuppressWarnings("unchecked")
// Método gerado automaticamente
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
