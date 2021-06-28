CREATE TABLE pessoa (
    codigo BIGINT  (20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR (50) NOT NULL),
    logradouro VARCHAR (30 ),
    numero VARCHAR (30),
    complemento VARCHAR (30),
    bairro VARCHAR (30),
    cep VARCHAR (30),
    cidade VARCHAR (30),
    estado VARCHAR (30),
    ativo BOOLEAN NOT NULL
    ENGINE =InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome,logradouro, numero, complemento, bairro, cep, estado,ativo) value('MARLON RIBEIRO', 'RUA 19 ','402',NULL,'JARDIM VITORIA','78055-000','Cuiaba','MT',true );
INSERT INTO pessoa (nome,logradouro, numero, complemento, bairro, cep, estado,ativo) value('JESUS JUNIOR','RUA 20','360',null ,'TERRA PROMETIDA','78055-000','Cuiaba','MT',true);
INSERT INTO pessoa (nome,logradouro, numero, complemento, bairro, cep, estado,ativo) value('MARIA','RUA 28','152',null,'Rio Branco','56.200-56','Rio de janeiro','RJ',true);
INSERT INTO pessoa (nome,logradouro, numero, complemento, bairro, cep, estado,ativo) value('Josué Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true);
INSERT INTO pessoa (nome,logradouro, numero, complemento, bairro, cep, estado,ativo) value('Carlos Santana', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Pedro Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true);