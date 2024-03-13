package com.sgb.biblioteca.dao;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.sgb.biblioteca.model.Emprestimo;
import com.sgb.biblioteca.model.Situacao;
import com.sgb.biblioteca.model.DTOs.EmprestimoDTO;

public interface EmprestimoDAO extends CrudRepository<Emprestimo, Long>{

    @Query("SELECT e.id, u.nome, l.titulo, a.nome AS autor, e.data_devolucao, e.situacao FROM biblioteca.emprestimo e " +
            "JOIN biblioteca.user u ON e.user_id = u.id " +
            "JOIN biblioteca.livro l ON e.livro_id = l.id " +
            "JOIN biblioteca.autor a ON l.autor_id = a.id  " +
            "ORDER BY e.id")
    List<EmprestimoDTO> listaEmprestimos();
    
    @Query("SELECT e.id, u.nome, l.titulo, a.nome AS autor, e.data_devolucao, e.situacao FROM biblioteca.emprestimo e " +
            "JOIN biblioteca.user u ON e.user_id = u.id " +
            "JOIN biblioteca.livro l ON e.livro_id = l.id " +
            "JOIN biblioteca.autor a ON l.autor_id = a.id  " +
            "WHERE e.situacao = 'ABERTO' " +
            "ORDER BY e.id")
    List<EmprestimoDTO> listaEmprestimosAbertos();

    @Modifying
    @Query("UPDATE biblioteca.emprestimo SET situacao = :situacao WHERE id = :id")
    void updateSituacao(Long id, Situacao situacao);

}
