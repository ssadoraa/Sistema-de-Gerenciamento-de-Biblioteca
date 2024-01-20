package com.sgb.biblioteca.controller.normal;

import com.sgb.biblioteca.model.Livro;
import com.sgb.biblioteca.service.GeneroService;
import com.sgb.biblioteca.service.LivroService;

import lombok.AllArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
@AllArgsConstructor
public class LivroController {

    private LivroService livroService;
    private GeneroService generoService;

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model){
        val livro = livroService.findLivroById(id);
        model.addAttribute("livro", livro);

        return "livro/get";
    }

    @GetMapping("/new")
    public String edit(Model model){
        val generos = generoService.findAllGeneros();

        model.addAttribute("generos", generos);
        
        return "livro/edit";
    }

    @PostMapping("/new")
    public String post(Livro livro){
        livroService.save(livro);
        return "livro/edit";
    }
}
