create table genero(
	id bigint(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

create table autor(
	id bigint(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

create table editora (
	id bigint(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(150),
    telefone VARCHAR(20),
    descricao VARCHAR(150),
    PRIMARY KEY(id)
);

create table livro (
	id bigint(20) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    id_editora bigint(20),
    id_genero bigint(20),
    id_autor bigint(20),
    ano integer,
    edicao VARCHAR(100),
    quantidade integer,
    PRIMARY KEY(id),
    FOREIGN KEY(id_editora) REFERENCES editora(id),
    FOREIGN KEY(id_genero) REFERENCES genero(id),
    FOREIGN KEY(id_autor) REFERENCES autor(id)
);