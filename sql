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

create table user (
	id BIGINT(20) NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(1000) NOT NULL,
    role VARCHAR(100) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo VARCHAR(20) NOT NULL,
    endereco VARCHAR(1000) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL,
);

CREATE TABLE emprestimo (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    livro_id BIGINT(20) NOT NULL,
    user_id BIGINT(20) NOT NULL,
    funcionario_id BIGINT(20) NOT NULL,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT emprestimo_cliente_FK FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT emprestimo_funcionario_FK FOREIGN KEY (funcionario_id) REFERENCES funcionario (id),
    CONSTRAINT emprestimo_livro_FK FOREIGN KEY (livro_id) REFERENCES livro (id)
);

insert into genero (id, nome)
values
(1, "Aventura"),
(2, "Autoajuda"),
(3, "Biografia"),
(4, "Conto"),
(5, "Crônica"),
(6, "Drama"),
(7, "Didático"),
(8, "Ficção científica"),
(9, "Fantasia"),
(10, "História em quadrinhos"),
(11, "Horror"),
(12, "Mistério"),
(13, "Poesia"),
(14, "Policial"),
(15, "Romance"),
(16, "Suspense"),
(17, "Terror"),
(18, "Viagem");