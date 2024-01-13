package com.sgb.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "livro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livro {
    @Id
    private long id;
    private String titulo;
    private long editoraId;
    private long generoId;
    private long autorId;
    private int ano;
    private String edicao;
    private int quantidade;

}

