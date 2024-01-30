package com.sgb.biblioteca.controller.normal;

import com.sgb.biblioteca.model.Livro;
import com.sgb.biblioteca.service.GeneroService;
import com.sgb.biblioteca.service.LivroService;

import lombok.AllArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller 
@AllArgsConstructor
@RequestMapping("/livro")
public class LivroController {

    private LivroService livroService;

    private GeneroService generoService;

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id){
        val livro = livroService.findLivroComDependenciaById(id);

        return new ModelAndView("livro/get")
            .addObject("livro", livro);
    }

    @GetMapping("/new")
    public ModelAndView novo(){
        return edit(Livro.empty());
    }
    
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        val livro = livroService.findLivroById(id);
        return edit(livro);
    }

    public ModelAndView edit(){
        val generos = generoService.findAllGeneros();

        return new ModelAndView("livro/edit")
            .addObject("generos", generos);
    }

    @PostMapping("/new")
    public String post(Livro livro){
        livroService.save(livro);
        
        return "livro/edit";
    }

    private ModelAndView edit(Livro livro){
        val generos = generoService.findAllGeneros();

        return new ModelAndView("livro/edit")
            .addObject("livro", livro)
            .addObject("generos", generos);
    }

    @GetMapping()
    public ModelAndView list(){
        val livros = livroService.listagemLivros();

        return new ModelAndView("livro/list")
            .addObject("livros", livros);
    }
}
