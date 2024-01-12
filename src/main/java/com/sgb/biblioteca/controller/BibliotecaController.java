package com.sgb.biblioteca.controller;

import com.sgb.biblioteca.dao.BibliotecaDAO;
import com.sgb.biblioteca.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BibliotecaController {

    @Autowired
    private BibliotecaDAO bibliotecaDAO;

    @GetMapping("/biblioteca")
    public String get(){
        return "edit";
    }

    @PostMapping("/biblioteca")
    public String post(Livro livro){
        bibliotecaDAO.save(livro);
        return "edit";
    }
}
