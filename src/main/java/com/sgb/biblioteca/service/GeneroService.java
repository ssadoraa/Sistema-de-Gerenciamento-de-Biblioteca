package com.sgb.biblioteca.service;

import com.sgb.biblioteca.model.Genero;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import com.sgb.biblioteca.dao.GeneroDAO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GeneroService {
    
    private GeneroDAO generoDAO;

    public List<Genero> findAllGeneros(){

        Iterable<Genero> generosIterable = generoDAO.findAll();
        List<Genero> generosList = StreamSupport.stream(generosIterable.spliterator(), false)
                                        .collect(Collectors.toList());
        
        return generosList;
    }
    
}
