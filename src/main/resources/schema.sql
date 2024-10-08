CREATE TABLE IF NOT EXISTS `user` (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `aplicativo` (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            nome VARCHAR(255) NOT NULL,
    custo_mensal VARCHAR(255) NOT NULL
    );
