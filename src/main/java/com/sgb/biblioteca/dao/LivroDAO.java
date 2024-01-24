package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.Livro;
import org.springframework.data.repository.CrudRepository;


public interface LivroDAO extends CrudRepository<Livro, Long> {
}

