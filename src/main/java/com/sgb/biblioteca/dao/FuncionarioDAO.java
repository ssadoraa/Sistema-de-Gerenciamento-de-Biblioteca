package com.sgb.biblioteca.dao;

import org.springframework.data.repository.CrudRepository;
import com.sgb.biblioteca.model.Funcionario;

public interface FuncionarioDAO extends CrudRepository<Funcionario, Long>{
}
