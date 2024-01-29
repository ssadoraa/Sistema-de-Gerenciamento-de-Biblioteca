package com.sgb.biblioteca.controller.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sgb.biblioteca.service.EditoraService;

import lombok.val;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
@AllArgsConstructor
@RequestMapping("/editora")
public class EditoraController {
    
    private EditoraService editoraService;

    @GetMapping("{id}")
    public ModelAndView get(@PathVariable Long id) {
        val editora = editoraService.findByIdFormatado(id);

        return new ModelAndView("editora/get")
            .addObject("editora", editora);
    }
    

}
