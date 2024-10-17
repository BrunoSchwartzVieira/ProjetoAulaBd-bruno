-- Criação do banco de dados
CREATE DATABASE sistema_agenda;
USE sistema_agenda;

-- Criação da tabela de usuários
CREATE TABLE tb_usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(100) NOT NULL,
    login_usuario VARCHAR(50) NOT NULL UNIQUE,
    senha_usuario VARCHAR(100) NOT NULL,
    perfil VARCHAR(20) NOT NULL
);

-- Criação da tabela de clientes
CREATE TABLE tb_clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100) NOT NULL,
    cpf_cnpj VARCHAR(20) NOT NULL UNIQUE
);

-- Criação da tabela de agenda
CREATE TABLE tb_agenda (
    id_agenda INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    cliente_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES tb_clientes(id_cliente) ON DELETE CASCADE
);

-- Inserção de usuários
INSERT INTO tb_usuarios (usuario, login_usuario, senha_usuario, perfil)
VALUES 
('João Silva', 'adm', '1', 'admin'),
('Maria Souza', 'user', '2', 'user');

-- Inserção de clientes
INSERT INTO tb_clientes (nome, endereco, telefone, email, cpf_cnpj)
VALUES
('Empresa XYZ', 'Rua 1, Número 123', '1122334455', 'contato@xyz.com.br', '12345678900123'),
('José da Silva', 'Rua 2, Número 456', '11987654321', 'jose@silva.com', '12345678909');

-- Inserção na agenda
INSERT INTO tb_agenda (data, hora, descricao, cliente_id)
VALUES 
('2024-10-15', '10:00:00', 'Reunião de negócios', 1),
('2024-10-16', '14:30:00', 'Consulta com o advogado', 2);

-- Consulta para verificar os dados
select * from tb_agenda;
SELECT * FROM tb_usuarios;
SELECT * FROM tb_clientes;
SELECT * FROM tb_clientes WHERE cpf_cnpj IN ('12345678900123', '12345678909');
SELECT a.id_agenda, a.data, a.hora, a.descricao, c.nome AS cliente 
FROM tb_agenda a
JOIN tb_clientes c ON a.cliente_id = c.id_cliente;


DESCRIBE tb_usuarios;
DESCRIBE tb_clientes;
DESCRIBE tb_agenda;
-- Mostrar todas as tabelas
SHOW TABLES;



