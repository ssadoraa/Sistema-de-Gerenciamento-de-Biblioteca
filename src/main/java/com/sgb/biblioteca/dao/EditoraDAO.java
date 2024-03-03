package com.sgb.biblioteca.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.sgb.biblioteca.model.Editora;

public interface EditoraDAO extends CrudRepository<Editora, Long> {

    @Query("SELECT e.id, e.nome FROM biblioteca.editora e "
           + " WHERE e.nome LIKE CONCAT('%', :nome, '%')")
    List<Editora> editoraQuery(String nome);

    @Query("SELECT * FROM biblioteca.editora e "
           + "ORDER BY e.nome;")
    List<Editora> listagemEditora();
}
