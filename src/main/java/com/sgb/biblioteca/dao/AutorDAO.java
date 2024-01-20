package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.Autor;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface AutorDAO extends CrudRepository<Autor, Long> {
   
    @Query("SELECT * FROM biblioteca.autor a "
           + " WHERE a.nome LIKE :nome")
    List<Autor> p(String nome);
}
