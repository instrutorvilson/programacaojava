-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE produto (
idProduto serial PRIMARY KEY,
descricao varchar(50),
preco float,
estoque float
);

CREATE TABLE venda (
idVenda serial PRIMARY KEY,
data date,
status varchar(1),
idCliente int
);

CREATE TABLE itens (
idItem serial PRIMARY KEY,
idProduto int,
idVenda int,
qtde float,
precoItem float,
FOREIGN KEY(idProduto) REFERENCES produto (idProduto),
FOREIGN KEY(idVenda) REFERENCES venda (idVenda)
);

CREATE TABLE cliente (
idCliente serial PRIMARY KEY,
nome varchar(50),
fone varchar(14),
email varchar(50)
);

ALTER TABLE venda ADD FOREIGN KEY(idCliente) REFERENCES cliente (idCliente);
