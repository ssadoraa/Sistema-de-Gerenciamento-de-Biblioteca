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

    public void save(Autor autor){
        autorDAO.save(autor);
    }

    public Autor findById(Long id){
        return autorDAO.findById(id).orElse(null);
    }

    public List<Autor> findAutorByQuery(String nome){
        return autorDAO.autorQuery(nome);
    }
    
}
