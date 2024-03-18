package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.Autor;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface AutorDAO extends CrudRepository<Autor, Long> {
   
    @Query("SELECT a.id, a.nome FROM biblioteca.autor a "
           + " WHERE a.nome LIKE CONCAT('%', :nome, '%')")
    List<Autor> autorQuery(String nome);
    
    @Query("SELECT a.id, a.nome FROM biblioteca.autor a "
           + " ORDER BY a.nome")
    List<Autor> findAllAutores();
}
