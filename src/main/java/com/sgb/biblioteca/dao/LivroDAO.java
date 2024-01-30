package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.Livro;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;


public interface LivroDAO extends CrudRepository<Livro, Long> {
    
    @Query("SELECT * FROM biblioteca.livro l "
           + "ORDER BY l.titulo;")
    List<Livro> listagemLivros();
}

