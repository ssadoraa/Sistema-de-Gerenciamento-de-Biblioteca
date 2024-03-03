package com.sgb.biblioteca.dao;

import org.springframework.data.repository.CrudRepository;

import com.sgb.biblioteca.model.Emprestimo;

public interface EmprestimoDAO extends CrudRepository<Emprestimo, Long>{

}
