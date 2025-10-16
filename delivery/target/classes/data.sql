-- Inserir restaurantes
INSERT INTO restaurante (id, nome, endereco) VALUES
(1, 'Pizzaria Bella', 'Av. Paulista, 1000 - São Paulo/SP'),
(2, 'Burger House', 'Rua Augusta, 500 - São Paulo/SP'),
(3, 'Sushi Master', 'Rua Liberdade, 200 - São Paulo/SP');

-- Inserir produtos
INSERT INTO produto (id, nome, preco, restaurante_id) VALUES
-- Pizzaria Bella
(1, 'Pizza Margherita', 35.90, 1),
(2, 'Pizza Calabresa', 38.90, 1),
(3, 'Lasanha Bolonhesa', 28.90, 1),

-- Burger House
(4, 'X-Burger', 18.90, 2),
(5, 'X-Bacon', 22.90, 2),
(6, 'Batata Frita', 12.90, 2),

-- Sushi Master
(7, 'Combo Sashimi', 45.90, 3),
(8, 'Hot Roll Salmão', 32.90, 3),
(9, 'Temaki Atum', 15.90, 3);

-- Inserir clientes
INSERT INTO cliente (id, nome, email, telefone) VALUES
(1, 'João Silva', 'joao@email.com', '(11) 99999-1111'),
(2, 'Maria Santos', 'maria@email.com', '(11) 99999-2222'),
(3, 'Pedro Oliveira', 'pedro@email.com', '(11) 99999-3333');

-- Inserir pedidos
INSERT INTO pedido (id, cliente_id, produto_id, quantidade, data_pedido) VALUES
(1, 1, 1, 1, CURRENT_TIMESTAMP), -- João pediu 1x Pizza Margherita
(2, 2, 5, 2, CURRENT_TIMESTAMP), -- Maria pediu 2x X-Bacon
(3, 3, 7, 1, CURRENT_TIMESTAMP); -- Pedro pediu 1x Combo Sashimi
