package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.Livro;
import org.springframework.data.repository.CrudRepository;


public interface BibliotecaDAO extends CrudRepository<Livro, Long> {
}

