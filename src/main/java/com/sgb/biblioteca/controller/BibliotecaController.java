package com.sgb.biblioteca.controller;

import com.sgb.biblioteca.dao.BibliotecaDAO;
import com.sgb.biblioteca.model.Livro;
import com.sgb.biblioteca.service.BibliotecaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BibliotecaController {


    private BibliotecaService bibliotecaService;

    @GetMapping("/biblioteca")
    public String get(){
        return "edit";
    }

    @PostMapping("/biblioteca")
    public String post(Livro livro){
        bibliotecaService.save(livro);
        return "edit";
    }
}
