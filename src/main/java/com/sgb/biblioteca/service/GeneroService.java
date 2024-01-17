package com.sgb.biblioteca.service;

import com.sgb.biblioteca.model.Genero;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.sgb.biblioteca.dao.GeneroDAO;
import lombok.AllArgsConstructor;
import lombok.val;

@Service
@AllArgsConstructor
public class GeneroService {
    
    private GeneroDAO generoDAO;

    public List<Genero> findAllGeneros(){
        val generosIterable = generoDAO.findAll();
        List<Genero> generosList = new ArrayList<>();
        generosIterable.forEach(generosList::add);
        
        return generosList;
    }
    
}
