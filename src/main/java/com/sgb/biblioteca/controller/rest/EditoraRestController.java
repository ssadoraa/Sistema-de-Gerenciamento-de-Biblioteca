package com.sgb.biblioteca.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import com.sgb.biblioteca.model.Editora;
import com.sgb.biblioteca.service.EditoraService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/api/editoras")
public class EditoraRestController {

    private final EditoraService editoraService;

    @GetMapping
    @ResponseBody
    public List<Editora> findByQuery(@RequestParam String busca) {
        return editoraService.findEditoraByQuery(busca);
    }    
}
