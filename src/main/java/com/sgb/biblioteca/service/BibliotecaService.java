package com.sgb.biblioteca.service;

import com.sgb.biblioteca.dao.BibliotecaDAO;
import com.sgb.biblioteca.model.Livro;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BibliotecaService {

    private BibliotecaDAO bibliotecaDAO;

    public void save(Livro livro){
        bibliotecaDAO.save(livro);
    }

}
