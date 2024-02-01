package com.sgb.biblioteca.controller.normal;

import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;
import lombok.val;
import com.sgb.biblioteca.service.EditoraService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgb.biblioteca.model.Editora;
import com.sgb.biblioteca.model.Livro;

import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/editora")
public class EditoraController {
    
    private EditoraService editoraService;

    @GetMapping()
    public ModelAndView list() {
        val editoras = editoraService.listagemEditoras();
        return new ModelAndView("biblioteca/editora/list")
            .addObject("editoras", editoras);
    }

    
    @GetMapping("{id}")
    public ModelAndView get(@PathVariable Long id) {
        val editora = editoraService.findByIdFormatado(id);

        return new ModelAndView("biblioteca/editora/get")
            .addObject("editora", editora);
    }
    

    @GetMapping("/new")    
    public ModelAndView novo(){
        return edit(Editora.empty());
    }
    
    @GetMapping("/{id}/edit")    
    public ModelAndView edit(@PathVariable Long id){
        val editora = editoraService.findById(id);
        return edit(editora);
    }
    
    private static ModelAndView edit(Editora editora){
        return new ModelAndView("biblioteca/editora/edit")
            .addObject("editora", editora);
    }


    @PostMapping("/new")
    public String post(Editora editora, RedirectAttributes redirectAttributes){
        editoraService.save(editora);
        
        redirectAttributes.addAttribute("id", editora.getId());
        
        return "redirect:/editora/{id}";
    }
}
