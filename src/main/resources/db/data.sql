-- USUARIO

DROP TABLE IF EXISTS Usuario CASCADE;
CREATE TABLE Usuario (codigo INT PRIMARY KEY,
                      nome VARCHAR(50),
                      senha VARCHAR(50));
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

-- CLIENTE

DROP TABLE IF EXISTS Cliente CASCADE;
CREATE TABLE Cliente (codigo INT PRIMARY KEY,
                      nome VARCHAR(100),
                      email VARCHAR(100));
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

-- APLICATIVO

DROP TABLE IF EXISTS Aplicativo CASCADE;
CREATE TABLE Aplicativo (codigo INT PRIMARY KEY,
                         nome VARCHAR(100),
                         customensal DECIMAL(10, 2));
INSERT INTO Aplicativo (codigo, nome, customensal) VALUES
                                                       (3, 'Empresa X0', 150.00),
                                                       (4, 'Empresa X00', 200.00),
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

-- PAGAMENTO

DROP TABLE IF EXISTS Pagamento CASCADE;
CREATE TABLE Pagamento (codigo INT PRIMARY KEY,
                        id_assinatura INT,
                        valorPago DECIMAL(10, 2),
                        promocao VARCHAR(100),
                        FOREIGN KEY (id_assinatura) REFERENCES Aplicativo(codigo));
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
DROP TABLE IF EXISTS assinatura CASCADE;
CREATE TABLE assinatura (
                             cod_assinatura BIGINT AUTO_INCREMENT PRIMARY KEY, -- Chave primária
                             cliente_codigo BIGINT NOT NULL,                   -- Código do cliente
                             aplicativo_codigo BIGINT NOT NULL,                -- Código do aplicativo
                             inicio_vigencia DATE NOT NULL,                     -- Data de início da vigência
                             fim_vigencia DATE NOT NULL,                        -- Data de fim da vigência
                             statusativo VARCHAR(20) NOT NULL,                 -- Status da assinatura (ex: ATIVO, INATIVO)
                             codigo BIGINT NOT NULL,                            -- Código adicional, se necessário
                             FOREIGN KEY (cliente_codigo) REFERENCES Cliente(codigo), -- Referência à tabela de clientes
                             FOREIGN KEY (aplicativo_codigo) REFERENCES Aplicativo(codigo) -- Referência à tabela de aplicativos
);


INSERT INTO assinatura (cod_assinatura, cliente_codigo, aplicativo_codigo, inicio_vigencia, fim_vigencia, statusativo, codigo)
VALUES
    (1, 1, 3, '2024-10-21', '2024-11-20', 'ATIVO', 1001),
    (2, 2, 3, '2024-10-22', '2024-11-21', 'ATIVO', 1002),
    (3, 3, 6, '2024-10-23', '2024-11-22', 'ATIVO', 1003),
    (4, 1, 4, '2024-10-24', '2024-11-23', 'ATIVO', 1004),
    (5, 2, 5, '2024-10-25', '2024-11-24', 'ATIVO', 1005),
    (6, 3, 6, '2024-10-26', '2024-11-25', 'ATIVO', 1006),
    (7, 1, 7, '2024-10-27', '2024-11-26', 'ATIVO', 1007),
    (8, 2, 8, '2024-10-28', '2024-11-27', 'ATIVO', 1008),
    (9, 3, 9, '2024-10-29', '2024-11-28', 'ATIVO', 1009),
    (10, 1, 10, '2024-10-30', '2024-11-29', 'ATIVO', 1010);
