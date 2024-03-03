package com.sgb.biblioteca.controller.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.service.FuncionarioService;


@Controller
@AllArgsConstructor
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {
        val funcionario = funcionarioService.findByIdCamposFormatados(id);
        return new ModelAndView("biblioteca/funcionario/get")
            .addObject("funcionario", funcionario);
    }
    
    
    @GetMapping("/new")
    public ModelAndView novo(){
        return novoEdit(UserModel.empty());
    }
    
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        val funcionario = funcionarioService.findByIdCamposFormatados(id);
        return novoEdit(funcionario);
    }

    private ModelAndView novoEdit(UserModel funcionario){
        return new ModelAndView("biblioteca/funcionario/edit")
            .addObject("funcionario", funcionario);
    }

    @PostMapping("/new")
    public String post(UserModel funcionario){
        funcionarioService.save(funcionario);;
        return "redirect:/funcionario/{id}";
    }

    @GetMapping("")
    public ModelAndView list() {
        val funcionarios = funcionarioService.listagemFuncionarios();
        return new ModelAndView("biblioteca/funcionario/list")
            .addObject("funcionarios", funcionarios);
    }
}
