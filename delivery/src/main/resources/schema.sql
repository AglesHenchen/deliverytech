-- Tabela: restaurante
CREATE TABLE restaurante (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    endereco VARCHAR(255)
);

-- Tabela: cliente
CREATE TABLE cliente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(20)
);

-- Tabela: produto
CREATE TABLE produto (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    preco DOUBLE,
    restaurante_id BIGINT,
    CONSTRAINT fk_produto_restaurante FOREIGN KEY (restaurante_id) REFERENCES restaurante(id)
);

-- Tabela: pedido
CREATE TABLE pedido (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cliente_id BIGINT,
    produto_id BIGINT,
    quantidade INTEGER,
    data_pedido TIMESTAMP,
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    CONSTRAINT fk_pedido_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
);
