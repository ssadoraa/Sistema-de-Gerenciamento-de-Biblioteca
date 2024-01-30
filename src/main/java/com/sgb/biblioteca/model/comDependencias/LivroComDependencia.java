package com.sgb.biblioteca.model.comDependencias;

import com.sgb.biblioteca.model.Autor;
import com.sgb.biblioteca.model.Editora;
import com.sgb.biblioteca.model.Genero;


public record LivroComDependencia(
    long id,
    String titulo,
    Editora editora,
    Genero genero,
    Autor autor,
    int ano,
    String edicao,
    int quantidade) {
}
