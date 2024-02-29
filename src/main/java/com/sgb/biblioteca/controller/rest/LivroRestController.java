package com.sgb.biblioteca.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import com.sgb.biblioteca.model.Livro;
import com.sgb.biblioteca.service.LivroService;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/api/livros")
public class LivroRestController {

    private final LivroService livroService;
    
    @GetMapping
    @ResponseBody
    public List<Livro> findByQuery(@RequestParam String busca){
        return livroService.findLivroByQuery(busca);
    }

}