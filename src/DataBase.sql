-- usuario = "postgres";  
-- senha = "admin0123";
CREATE DATABASE geracaovida_alunos;

CREATE TABLE pais
(
  nome_pai character varying,
  tel_residencia_pai character varying,
  tel_pai character varying,
  tel_trabalho_pai character varying NOT NULL,
  ramal_trabalho_pai character varying NOT NULL,
  end_pai character varying,
  cep_pai character varying,
  bairro_pai character varying,
  email_pai character varying,
  forma_contato_pai character varying,
  membro_pai character varying,
  igreja_pai character varying,
  nome_mae character varying,
  tel_residencia_mae character varying,
  tel_mae character varying,
  tel_trabalho_mae character varying NOT NULL,
  ramal_trabalho_mae character varying NOT NULL,
  end_mae character varying,
  cep_mae character varying,
  bairro_mae character varying,
  email_mae character varying,
  forma_contato_mae character varying,
  membro_mae character varying,
  igreja_mae character varying,
  id integer NOT NULL,
  numero character varying,
  numero_mae character varying,
  CONSTRAINT pais_pkey PRIMARY KEY (id)
);

CREATE TABLE crianca
(
  nome character varying NOT NULL,
  id integer NOT NULL,
  idade integer NOT NULL,
  turma character varying NOT NULL,
  data_aniversario character(10) NOT NULL,
  id_pais integer NOT NULL,
  alergia character varying,
  alergico character varying(200),
  irmaos character varying,
  nomeirmao1 character varying,
  nomeirmao2 character varying,
  nomeirmao3 character varying,
  data_aniversario_irmao1 character varying,
  data_aniversario_irmao2 character varying,
  data_aniversario_irmao3 character varying,
  CONSTRAINT crianca_pkey PRIMARY KEY (id),
  CONSTRAINT crianca_id_pais_fkey FOREIGN KEY (id_pais)
      REFERENCES pais (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE usuario
(
  nome character varying NOT NULL,
  senha character varying NOT NULL,
  login character varying NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (login)
);

insert into usuario (nome,senha,login) values ('admin','admin','admin');