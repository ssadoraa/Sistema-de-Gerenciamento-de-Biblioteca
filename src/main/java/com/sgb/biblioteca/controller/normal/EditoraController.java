package com.sgb.biblioteca.controller.normal;

import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.val;
import com.sgb.biblioteca.service.EditoraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sgb.biblioteca.service.EditoraService;
import lombok.val;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;
import com.sgb.biblioteca.model.Editora;
import com.sgb.biblioteca.service.EditoraService;
import lombok.val;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


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
    

    @GetMapping("{id}")
    public ModelAndView get(@PathVariable Long id) {
        val editora = editoraService.findByIdFormatado(id);

        return new ModelAndView("editora/get")
            .addObject("editora", editora);
    }
    


    private EditoraService editoraService;
    
    @GetMapping("/new")    
    public ModelAndView novo(){
        return edit(Editora.empty());
    }
    
    @GetMapping("/{id}/edit")    
    public ModelAndView edit(@PathVariable Long id){
        val editora = editoraService.findById(id);
        return edit(editora);
    }
    
    @PostMapping("/new")    
    public String post(Editora editora){
        editoraService.save(editora);
        return "editora/get";
    }
    
    private static ModelAndView edit(Editora editora){
        return new ModelAndView("editora/edit")
            .addObject("editora", editora);
    }
}
