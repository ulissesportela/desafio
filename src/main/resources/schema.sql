
-- DROP DATABASE minhasfinancas;

CREATE DATABASE desafio;

CREATE SCHEMA desafio;

CREATE TABLE desafio.usuario
(
  id bigserial NOT NULL PRIMARY KEY,
  usuario character varying(20) NOT NULL,
  senha character varying(20) NOT NULL,
  data_cadastro date DEFAULT NOW()
);

INSERT INTO desafio.usuario (usuario, senha) VALUES('admin', '123456');
INSERT INTO desafio.usuario (usuario, senha) VALUES('comun', '123456');



CREATE TABLE desafio.cliente
(
  id bigserial NOT NULL PRIMARY KEY ,
  nome character varying(100) NOT NULL,
  cpf character varying(11) NOT NULL,
  cep character varying(8) NOT NULL,
  logradouro character varying(100) NOT NULL,
  bairro character varying(50) NOT NULL,
  cidade character varying(50) NOT NULL,
  uf character varying(2) NOT NULL,
  complemento character varying(256),
  data_cadastro date DEFAULT NOW()
);



CREATE TABLE desafio.telefone
(
  id bigserial NOT NULL PRIMARY KEY ,
  telefone character varying(11) NOT NULL,
  tipo character varying(11) CHECK (tipo IN ('RESIDENCIAL', 'COMERCIAL', 'CELULAR')) NOT NULL,
  id_cliente bigint REFERENCES desafio.cliente (id) NOT NULL,
  data_cadastro date DEFAULT NOW()
);

CREATE TABLE desafio.email
(
  id bigserial NOT NULL PRIMARY KEY ,
  email character varying(100) NOT NULL,
  id_cliente bigint REFERENCES desafio.cliente (id) NOT NULL,
  data_cadastro date DEFAULT NOW()
);
