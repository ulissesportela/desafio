
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



CREATE TABLE desafio.cliente (
	id bigserial NOT NULL,
	nome varchar(100) NOT NULL,
	cpf varchar(11) NOT NULL,
	cep varchar(8) NOT NULL,
	logradouro varchar(100) NOT NULL,
	bairro varchar(50) NOT NULL,
	cidade varchar(50) NOT NULL,
	uf varchar(2) NOT NULL,
	complemento varchar(256) NULL,
	data_cadastro date NULL DEFAULT now(),
	email varchar(255) NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id)
);



CREATE TABLE desafio.telefone
(
  id bigserial NOT NULL PRIMARY KEY ,
  telefone character varying(11) NOT NULL,
  cliente_id bigint REFERENCES desafio.cliente (id) NOT NULL,
  data_cadastro date DEFAULT NOW()
);
ALTER TABLE desafio.telefone ADD tipo bigint NULL;

CREATE TABLE desafio.email
(
  id bigserial NOT NULL PRIMARY KEY ,
  email character varying(100) NOT NULL,
  cliente_id bigint REFERENCES desafio.cliente (id) NOT NULL,
  data_cadastro date DEFAULT NOW()
);
