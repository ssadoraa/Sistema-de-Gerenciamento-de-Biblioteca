package com.sgb.biblioteca.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import com.sgb.biblioteca.model.DTOs.LivroAutorDTO;
import com.sgb.biblioteca.service.LivroAutorDTOService;
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

    private final LivroAutorDTOService livroAutorDTOService;
    
    @GetMapping
    @ResponseBody
    public List<LivroAutorDTO> findByQuery(@RequestParam String busca){
        return livroAutorDTOService.findLivroByQuery(busca);
    }

}