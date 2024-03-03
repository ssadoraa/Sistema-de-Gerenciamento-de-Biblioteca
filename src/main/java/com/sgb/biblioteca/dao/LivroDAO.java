package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.Livro;
import com.sgb.biblioteca.model.DTOs.LivroAutorDTO;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;


public interface LivroDAO extends CrudRepository<Livro, Long> {

    @Query("SELECT l.id, l.titulo, a.nome, l.quantidade FROM biblioteca.livro l " +
           " JOIN biblioteca.autor a ON l.autor_id = a.id" +
           " ORDER BY l.titulo")
    List<LivroAutorDTO> listagemLivros();

    @Query("SELECT l.id, l.titulo FROM biblioteca.livro l " +
           "WHERE l.titulo LIKE CONCAT('%', :titulo, '%')")
    List<Livro> livroQuery(String titulo);
}

