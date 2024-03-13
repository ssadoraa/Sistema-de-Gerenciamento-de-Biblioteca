package com.sgb.biblioteca.controller.normal;

import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;
import lombok.val;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sgb.biblioteca.model.Autor;
import com.sgb.biblioteca.service.AutorService;


@Controller
@AllArgsConstructor
@RequestMapping("/autor")

public class AutorController {

    private AutorService autorService;

    @GetMapping("/new")    
    public ModelAndView novo(){
        return edit(Autor.empty());
    }
    
    @GetMapping("/{id}/edit")    
    public ModelAndView edit(@PathVariable Long id){
        val autor = autorService.findById(id);
        return edit(autor);
    }
    
    private static ModelAndView edit(Autor autor){
        return new ModelAndView("biblioteca/autor/edit")
            .addObject("autor", autor);
    }

    @PostMapping("/new")
    public String post(Autor autor, RedirectAttributes redirectAttributes){
        autorService.save(autor);
        
        redirectAttributes.addAttribute("id", autor.getId());
        
        return "redirect:/autor/{id}";
    }
    
}
