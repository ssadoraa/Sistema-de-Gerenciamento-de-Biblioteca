package com.sgb.biblioteca.dao;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.sgb.biblioteca.model.Emprestimo;
import com.sgb.biblioteca.model.DTOs.EmprestimoDTO;

public interface EmprestimoDAO extends CrudRepository<Emprestimo, Long>{

    @Query("SELECT e.id, u.nome, l.titulo, a.nome AS autor, e.data_emprestimo, e.data_devolucao FROM biblioteca.emprestimo e " +
            "JOIN biblioteca.user u ON e.user_id = u.id " +
            "JOIN biblioteca.livro l ON e.livro_id = l.id " +
            "JOIN biblioteca.autor a ON l.autor_id = a.id  " +
            "ORDER BY e.id;")
    List<EmprestimoDTO> listaEmprestimos();

}
