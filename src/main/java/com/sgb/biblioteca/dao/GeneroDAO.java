package com.sgb.biblioteca.dao;

import com.sgb.biblioteca.model.Genero;
import org.springframework.data.repository.CrudRepository;


public interface GeneroDAO extends CrudRepository<Genero, Long> {
}

