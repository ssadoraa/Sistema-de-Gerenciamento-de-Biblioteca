package com.sgb.biblioteca.service;

import com.sgb.biblioteca.dao.LivroDAO;
import com.sgb.biblioteca.model.Livro;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LivroService {

    private LivroDAO livroDAO;

    public void save(Livro livro){
        livroDAO.save(livro);
    }

    public Livro findLivroById(Long id){
        return livroDAO.findById(id).orElse(null);
    }

}
