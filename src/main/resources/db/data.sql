CREATE TABLE Usuarios (
                          codigo LONG NOT NULL,
                          nome VARCHAR,
                          senha VARCHAR
);

INSERT INTO Usuarios (codigo, nome, senha) VALUES
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

CREATE TABLE Clientes (
                         codigo LONG NOT NULL,
                         nome VARCHAR,
                         email VARCHAR
);

INSERT INTO Clientes (codigo, nome, email) VALUES
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


CREATE TABLE Aplicativos (
                             codigo LONG NOT NULL,
                          nome VARCHAR,
                             custoMensal double
);

INSERT INTO Aplicativos (codigo, nome, custoMensal) VALUES
                                                        (5, 'Empresa X1', 20),
                                                        (6, 'Empresa X2', FLOOR(RAND() * (500 - 10 + 1)) + 10),
                                                        (7, 'Empresa X3', FLOOR(RAND() * (500 - 10 + 1)) + 10),
                                                        (8, 'Empresa X4', FLOOR(RAND() * (500 - 10 + 1)) + 10),
                                                        (9, 'Empresa X5', FLOOR(RAND() * (500 - 10 + 1)) + 10),
                                                        (10, 'Empresa X8', FLOOR(RAND() * (500 - 10 + 1)) + 10),
                                                        (11, 'Empresa XSPACE', FLOOR(RAND() * (500 - 10 + 1)) + 10),
                                                        (12, 'Empresa XDragon', FLOOR(RAND() * (500 - 10 + 1)) + 10),
                                                        (13, 'Empresa XIPTV', FLOOR(RAND() * (500 - 10 + 1)) + 10),
                                                        (14, 'Empresa XINSS', 1000);




CREATE TABLE Pagamentos (
                            codigo BIGINT PRIMARY KEY NOT NULL,
                            id_assinatura BIGINT NOT NULL,
                            valorPago double,
                            promocao varchar
);
-- Pagamento 1
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (1, 3, 50.00, 'Promoção 1');

-- Pagamento 2
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (2, 4, 60.00, 'Promoção 2');

-- Pagamento 3
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (3, 5, 70.00, 'Promoção 3');

-- Pagamento 4
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (4, 6, 80.00, 'Promoção 4');

-- Pagamento 5
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (5, 7, 90.00, 'Promoção 5');

-- Pagamento 6
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (6, 8, 100.00, 'Promoção 6');

-- Pagamento 7
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (7, 9, 110.00, 'Promoção 7');

-- Pagamento 8
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (8, 10, 120.00, 'Promoção 8');

-- Pagamento 9
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (9, 11, 130.00, 'Promoção 9');

-- Pagamento 10
INSERT INTO Pagamentos (codigo, id_assinatura, valorPago, promocao)
VALUES (10, 12, 140.00, 'Promoção 10');

