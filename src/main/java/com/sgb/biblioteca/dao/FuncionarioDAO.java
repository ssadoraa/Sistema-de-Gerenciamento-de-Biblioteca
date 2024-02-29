package com.sgb.biblioteca.dao;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.sgb.biblioteca.model.Funcionario;

public interface FuncionarioDAO extends CrudRepository<Funcionario, Long>{

    @Query("SELECT * FROM biblioteca.funcionario f "
           + " WHERE f.nome LIKE :nome")
    List<Funcionario> funcionarioQuery(String nome);
}
