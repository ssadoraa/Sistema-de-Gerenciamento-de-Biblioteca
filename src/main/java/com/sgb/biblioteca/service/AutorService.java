package com.sgb.biblioteca.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sgb.biblioteca.dao.AutorDAO;
import com.sgb.biblioteca.model.Autor;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AutorService {

    private AutorDAO autorDAO;

    public List<Autor> findAutorByQuery(String nome){

        List<Autor> autores = autorDAO.p(nome);

        return autores;
    }
    
}
