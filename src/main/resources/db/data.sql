-- Exclusão das tabelas, se existirem


DROP TABLE IF EXISTS Usuario;

-- Criação da tabela Usuario
CREATE TABLE Usuario (
                         codigo INT PRIMARY KEY,
                         nome VARCHAR(50),
                         senha VARCHAR(50)
);

-- Criação da tabela Cliente
CREATE TABLE Cliente (
                         codigo INT PRIMARY KEY,
                         nome VARCHAR(100),
                         email VARCHAR(100)
);
DROP TABLE IF EXISTS Aplicativo;
-- Criação da tabela Aplicativo
CREATE TABLE Aplicativo (
                            codigo INT PRIMARY KEY,
                            nome VARCHAR(100),
                            custoMensal DECIMAL(10, 2)
);
DROP TABLE IF EXISTS Pagamento;

-- Criação da tabela Pagamento
CREATE TABLE Pagamento (
                           codigo INT PRIMARY KEY,
                           id_assinatura INT,
                           valorPago DECIMAL(10, 2),
                           promocao VARCHAR(100),
                           FOREIGN KEY (id_assinatura) REFERENCES Aplicativo(codigo)
);

-- Inserção de valores na tabela Usuario
INSERT INTO Usuario (codigo, nome, senha) VALUES
                                              (1, 'Lucas', 'senha0'),
                                              (2, 'Maria', 'senha1'),
                                              (3, 'Pedro', 'senha2'),
                                              (4, 'Ana', 'senha3'),
                                              (5, 'Lucas', 'senha4'),
                                              (6, 'Julia', 'senha5'),
                                              (7, 'Mateus', 'senha6'),
                                              (8, 'Carla', 'senha7'),
                                              (9, 'Fernanda', 'senha8'),
                                              (10, 'Rafael', 'senha9'),
                                              (11, 'Mariana', 'senha10');

-- Inserção de valores na tabela Cliente
INSERT INTO Cliente (codigo, nome, email) VALUES
                                              (1, 'Empresa A', 'empresa_a@example.com'),
                                              (2, 'Empresa B', 'empresa_b@example.com'),
                                              (3, 'Empresa C', 'empresa_c@example.com'),
                                              (4, 'Empresa D', 'empresa_d@example.com'),
                                              (5, 'Empresa E', 'empresa_e@example.com'),
                                              (6, 'Empresa F', 'empresa_f@example.com'),
                                              (7, 'Empresa G', 'empresa_g@example.com'),
                                              (8, 'Empresa H', 'empresa_h@example.com'),
                                              (9, 'Empresa I', 'empresa_i@example.com'),
                                              (10, 'Empresa J', 'empresa_j@example.com');

-- Inserção de valores na tabela Aplicativo
INSERT INTO Aplicativo (codigo, nome, custoMensal) VALUES
                                                       (5, 'Empresa X1', 20),
                                                       (6, 'Empresa X2', 100),
                                                       (7, 'Empresa X3', 200),
                                                       (8, 'Empresa X4', 300),
                                                       (9, 'Empresa X5', 400),
                                                       (10, 'Empresa X8', 500),
                                                       (11, 'Empresa XSPACE', 600),
                                                       (12, 'Empresa XDragon', 700),
                                                       (13, 'Empresa XIPTV', 800),
                                                       (14, 'Empresa XINSS', 1000);

-- Inserção de valores na tabela Pagamento
INSERT INTO Pagamento (codigo, id_assinatura, valorPago, promocao) VALUES
                                                                       (1, 3, 50.00, 'Promoção 1'),
                                                                       (2, 4, 60.00, 'Promoção 2'),
                                                                       (3, 5, 70.00, 'Promoção 3'),
                                                                       (4, 6, 80.00, 'Promoção 4'),
                                                                       (5, 7, 90.00, 'Promoção 5'),
                                                                       (6, 8, 100.00, 'Promoção 6'),
                                                                       (7, 9, 110.00, 'Promoção 7'),
                                                                       (8, 10, 120.00, 'Promoção 8'),
                                                                       (9, 11, 130.00, 'Promoção 9'),
                                                                       (10, 12, 140.00, 'Promoção 10');
