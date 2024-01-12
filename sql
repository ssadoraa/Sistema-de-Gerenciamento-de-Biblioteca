create table genero(
	id BIGINT(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

create table autor(
	id BIGINT(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

create table editora (
	id BIGINT(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(100) NOT NULL,
    endereco VARCHAR(150),
    telefone VARCHAR(20),
    descricao VARCHAR(150),
    PRIMARY KEY(id)
);

create table livro (
	id BIGINT(20) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    editora_id BIGINT(20),
    genero_id BIGINT(20),
    autor_id BIGINT(20),
    ano INTEGER,
    edicao VARCHAR(100),
    quantidade INTEGER,
    PRIMARY KEY(id),
    FOREIGN KEY(id_editora) REFERENCES editora(id),
    FOREIGN KEY(id_genero) REFERENCES genero(id),
    FOREIGN KEY(id_autor) REFERENCES autor(id)
);
