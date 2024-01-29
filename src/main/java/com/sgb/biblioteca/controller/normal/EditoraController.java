package com.sgb.biblioteca.controller.normal;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.val;
import com.sgb.biblioteca.service.EditoraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@AllArgsConstructor
@RequestMapping("/editora")
public class EditoraController {
    
    private EditoraService editoraService;

    @GetMapping()
    public ModelAndView list() {
        val editoras = editoraService.listagemEditoras();
        return new ModelAndView("editora/list")
            .addObject("editoras", editoras);
    }
    
}
