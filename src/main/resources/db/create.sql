CREATE TABLE if not exists public.agendas (
                                              id int8 NOT NULL,
                                              titulo varchar(100) NOT NULL,
                                              nome varchar(100),
                                              CONSTRAINT pk_agendas PRIMARY KEY (id)
);

CREATE SEQUENCE public.seq_agendas;

CREATE TABLE if not exists public.contatos (
                                               id int8 NOT NULL,
                                               agenda_id int8,
                                               nome varchar(100) NOT NULL,
                                               sobrenome varchar(100) NOT NULL,
                                               cpf varchar(11) NOT NULL,
                                               email varchar(100) NOT NULL,
                                               end_logradouro varchar(200),
                                               end_bairro varchar(100),
                                               end_cidade varchar(100),
                                               end_cep NUMERIC(8),
                                               end_uf varchar(2),
                                               CONSTRAINT pk_contatos PRIMARY KEY (id),
                                               CONSTRAINT agenda_contato_fk1 FOREIGN KEY (agenda_id) references public.agendas
);

CREATE SEQUENCE public.seq_contatos;

CREATE TABLE if not exists public.telefones (
                                                id int8 NOT NULL,
                                                contato_id int8,
                                                numero numeric(11) NOT NULL,
                                                CONSTRAINT pk_telefone PRIMARY KEY (id),
                                                CONSTRAINT contato_telefone_fk1 FOREIGN KEY (contato_id) references public.contatos
);

CREATE SEQUENCE public.seq_telefones;



