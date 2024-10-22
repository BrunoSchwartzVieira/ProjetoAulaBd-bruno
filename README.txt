Alunos: Bruno Henrique e Nathan

- Sistema de Gerenciamento de Clientes e Agenda

- Descrição

Este projeto é um sistema de gerenciamento de clientes e agendamento de compromissos desenvolvido em Java com uma interface gráfica (Swing) e conectado a um banco de dados MySQL. O sistema permite realizar operações de CRUD (Criar, Ler, Atualizar, Deletar) para gerenciar informações de clientes e compromissos agendados.

- Arquitetura do Sistema

O sistema é dividido nas seguintes camadas:

1. Camada de Visão (View)
   - Responsável pela interface gráfica do usuário (GUI), que permite a interação com o sistema.
   - Classes: 
     - `TelaCadastroClientes`: Tela para cadastro e gerenciamento de clientes.
     - `TelaAgenda`: Tela para gerenciamento de compromissos.
     

2. Camada de Controle (Controller)
   - Intermediária que facilita a comunicação entre a interface gráfica e as operações no banco de dados.
   - Lógica principal de validação e controle de fluxos de dados.
   - Nota: Neste sistema, parte do controle está integrado nas classes de visão.

3. Camada de Modelo (Model)
   - Representa as entidades do sistema.
   - Classes: 
     - `ClienteDTO`: Representa os dados de um cliente.
     - `AgendaDTO`: Representa os dados de um compromisso agendado.

4. Camada de Acesso a Dados (DAO)
   - Responsável pela interação com o banco de dados MySQL, realizando operações de CRUD.
   - Classes:
     - `ClienteDAO`: Gerencia operações relacionadas aos clientes no banco de dados.
     - `AgendaDAO`: Gerencia operações relacionadas aos compromissos no banco de dados.
     - `ConexaoDAO`: Gerencia a conexão com o banco de dados.

- Configuração do Ambiente

 1. Pré-requisitos

- Java JDK 8 ou superior
- MySQL Server
- Biblioteca JDBC MySQL Connector (disponível em [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/))
- IDE Java (opcional, mas recomendada para desenvolvimento e execução)

 2. Configuração do Banco de Dados

1. Instalar o MySQL Server e configurar um usuário e senha. A configuração padrão do sistema assume o usuário `root` com senha `root`. Caso diferente, edite a classe `ConexaoDAO`.

2. Criar o Banco de Dados e Tabelas:

   Execute os seguintes comandos SQL para configurar as tabelas necessárias:

   ```sql
   CREATE DATABASE sistema_agenda;

   USE sistema_agenda;

   CREATE TABLE tb_clientes (
       id_cliente INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(100),
       endereco VARCHAR(200),
       telefone VARCHAR(20),
       email VARCHAR(100),
       cpf_cnpj VARCHAR(20)
   );

   CREATE TABLE agenda (
       id INT AUTO_INCREMENT PRIMARY KEY,
       data DATE,
       horario TIME,
       descricao TEXT,
       id_cliente INT,
       FOREIGN KEY (id_cliente) REFERENCES tb_clientes(id_cliente)
   );
   ```

 3. Configuração do Projeto

1. Baixe ou clone o repositório do projeto.
   
2. Adicione o MySQL Connector/J ao classpath do projeto. Se estiver usando uma IDE como NetBeans ou IntelliJ, você pode fazer isso adicionando o arquivo `.jar` do connector como uma dependência.

3. Edite as configurações de conexão na classe `ConexaoDAO`, caso seja necessário ajustar o nome do usuário, senha ou URL de conexão:

   ```java
   String url = "jdbc:mysql://localhost:3306/sistema_agenda";
   String user = "root"; // Ajuste aqui se necessário
   String password = "root"; // Ajuste aqui se necessário
   ```

- Execução do Sistema

1. Compile e execute o projeto:
   - Execute a classe `TelaCadastroClientes` ou `TelaAgenda` diretamente para iniciar a aplicação.
   - As janelas permitirão o cadastro e gestão de clientes e compromissos.

2. Funcionalidades:
   - Clientes:
     - Inserir, atualizar, deletar e listar clientes.
     - Pesquisar cliente por ID para edição.
   - Agenda:
     - Inserir e listar compromissos.
     - Associar compromissos aos clientes cadastrados.

- Estrutura do Projeto


src/
│
├── br/com/DTO/
│   ├── ClienteDTO.java        - Modelo para dados de clientes
│   └── AgendaDTO.java         - Modelo para dados de compromissos
│   └── UsuarioDTO.java
├── br/com/DAO/
│   ├── ClienteDAO.java        - Acesso a dados para clientes
│   ├── AgendaDAO.java         - Acesso a dados para compromissos
│   └── ConexaoDAO.java        - Gerenciamento de conexão com MySQL
│   └── UsuarioDAO.java
├── br/com/views/
│   ├── TelaCadastroClientes.java    - Interface para gerenciar clientes
│   └── TelaAgenda.java             - Interface para gerenciar compromissos
│	└──  TelaLogin.java
    └──  TelaPrincipal
    └──  TelaSobre
    └──  TelaUsuario		
└── README.md
```

Contribuição

Sinta-se à vontade para contribuir ao projeto! Para isso, faça um fork, adicione suas alterações e envie um Pull Request.

 Problemas Conhecidos

- Certifique-se de que o servidor MySQL está ativo antes de executar a aplicação.
- Verifique se o usuário e senha no `ConexaoDAO` correspondem às credenciais configuradas no MySQL.

 Licença

Este projeto é distribuído sob a Licença MIT. Consulte o arquivo `LICENSE` para obter mais informações.

---

 Nota Final

Esta estrutura de README fornece uma visão clara de como configurar, entender a arquitetura e executar o sistema. Você pode ajustar o conteúdo conforme necessário, adicionando ou removendo seções para melhor atender às especificidades do seu projeto.
