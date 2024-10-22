-- data.sql
-- Insert de Usuarios
INSERT INTO usuarios (id,login, password) VALUES (1,'admin', 'admin123');

-- Insert de aplicativos
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (1,'Discord', 13.50);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (2,'Moodle', 2.99);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (3,'Salsicha', 5.00);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (4,'Fork', 64.99);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (5,'Xbox', 45.00);

-- Insert de Clientes

INSERT INTO clientes (id,nome,email) VALUES (1, 'Michael Jordan', 'maikinJord@yahoo.com.br');
INSERT INTO clientes (id,nome,email) VALUES (2, 'Michael Kuster', 'maikaokuster@gmail.com');
INSERT INTO clientes (id,nome,email) VALUES (3, 'Bernardo Muller', 'berndmull@bernd.com');
INSERT INTO clientes (id,nome,email) VALUES (4, 'Francisco Lisboa', 'franlis@bernd.com');
INSERT INTO clientes (id,nome,email) VALUES (5, 'David Campos', 'david@benrd.com');
INSERT INTO clientes (id,nome,email) VALUES (6, 'Guilherme Barreto', 'guilh123@barreto.com');
INSERT INTO clientes (id,nome,email) VALUES (7, 'Advogado', 'advogado@advogado.com');
INSERT INTO clientes (id,nome,email) VALUES (8, 'Felipe Varehlla', 'felipe11@gmail.com');
INSERT INTO clientes (id,nome,email) VALUES (9, 'Felpo Filva', 'ff1249@gmail.com');
INSERT INTO clientes (id,nome,email) VALUES (10, 'Bernardo Copstein', 'bernardo@copstein.com');


-- Insert de Assinaturas
INSERT INTO assinaturas (id, aplicativo_id, cliente_id, inicio_vigencia, fim_vigencia) VALUES
                                                                                           (1, 1, 1, '2024-01-01', '2024-02-01'),
                                                                                           (2, 2, 2, '2024-06-01', '2024-07-01'),
                                                                                           (3, 3, 3, '2023-12-13', '2024-07-13'),
                                                                                           (4, 4, 4, '2024-06-04', '2024-07-04'),
                                                                                           (5, 5, 5, '2024-01-01', '2024-02-01');
