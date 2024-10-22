-- data.sql
-- Insert de Usuarios
INSERT INTO usuarios (id,login, password) VALUES (1,'admin', 'admin123');

-- Insert de aplicativos
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (1,'Discord', 13.50);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (2,'Moodle', 2.99);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (3,'Miro', 5.00);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (4,'CHATGPT', 64.99);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (5,'Xbox', 45.00);

-- Insert de Clientes

INSERT INTO clientes (id,nome,email) VALUES (1, 'Lucas Taborda', 'taborda.lucas@edu.pucrs.br');
INSERT INTO clientes (id,nome,email) VALUES (2, 'Gabriel Barbosa', 'Gabriel@Barbosa.com');
INSERT INTO clientes (id,nome,email) VALUES (3, 'Erick Muniz', 'Erick@Muniz.com');
INSERT INTO clientes (id,nome,email) VALUES (4, 'Renato Forte', 'Renato@Forte.com');
INSERT INTO clientes (id,nome,email) VALUES (5, 'David Campos', 'david@benrd.com');
INSERT INTO clientes (id, nome, email) VALUES (6, 'Mariana Oliveira', 'mariana.oliveira@gmail.com');
INSERT INTO clientes (id, nome, email) VALUES (7, 'João Pedro Martins', 'joaopedro.martins@hotmail.com');
INSERT INTO clientes (id, nome, email) VALUES (8, 'Patrícia Silva', 'patricia_silva@uol.com.br');
INSERT INTO clientes (id, nome, email) VALUES (9, 'André Gomes', 'andre.gomes@exemplo.com');
INSERT INTO clientes (id, nome, email) VALUES (10, 'Rafael Torres', 'rafael_torres@yahoo.com');
INSERT INTO clientes (id, nome, email) VALUES (11, 'Camila Ferreira', 'camila.ferreira@empresa.com');



-- Insert de Assinaturas
INSERT INTO assinaturas (id, aplicativo_id, cliente_id, inicio_vigencia, fim_vigencia) VALUES
                                                                                           (1, 1, 1, '2024-01-01', '2024-02-01'),
                                                                                           (2, 2, 2, '2024-06-01', '2024-07-01'),
                                                                                           (3, 3, 3, '2023-12-13', '2024-07-13'),
                                                                                           (4, 4, 4, '2024-06-04', '2024-07-04'),
                                                                                           (5, 5, 5, '2024-01-01', '2024-02-01');