package com.sgb.biblioteca.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import com.sgb.biblioteca.model.Autor;
import com.sgb.biblioteca.service.AutorService;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/api/autores")
public class AutorRestController {

    private final AutorService autorService;

    @GetMapping
    @ResponseBody
    public List<Autor> findByQuery(@RequestParam String busca){
        return autorService.findAutorByQuery(busca);
    }

}