package com.sgb.biblioteca.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.sgb.biblioteca.model.DTOs.LivroAutorDTO;

public interface LivroAutorDTODAO extends CrudRepository<LivroAutorDTO, Long>{

    @Query("SELECT l.id, l.titulo, a.nome FROM biblioteca.livro l " +
        "JOIN biblioteca.autor a ON l.autor_id = a.id " +
        "WHERE l.titulo LIKE CONCAT('%', :titulo, '%')" +
        " AND l.quantidade > 0")
    List<LivroAutorDTO> livroAutorQuery(String titulo);
    
}
