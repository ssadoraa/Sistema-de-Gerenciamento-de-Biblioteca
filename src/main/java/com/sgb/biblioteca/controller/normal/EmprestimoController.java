package com.sgb.biblioteca.controller.normal;

import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.sgb.biblioteca.model.Emprestimo;
import com.sgb.biblioteca.model.Funcionario;
import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.model.DTOs.LivroAutorDTO;
import com.sgb.biblioteca.service.EmprestimoService;
import com.sgb.biblioteca.service.FuncionarioService;
import com.sgb.biblioteca.service.LivroAutorDTOService;
import com.sgb.biblioteca.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    private LivroAutorDTOService livroAutorDTOService;

    private UserService userService;

    private FuncionarioService funcionarioService;

    @GetMapping("/new")
    public ModelAndView novo(){
        return novoEdit(Emprestimo.empty());
    }
    
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        val emprestimo = emprestimoService.findEmprestimoById(id);
        return novoEdit(emprestimo);
    }

    private ModelAndView novoEdit(Emprestimo emprestimo){
        LivroAutorDTO livro = null;
        UserModel user = null;
        Funcionario funcionario = null;

        if (emprestimo.getId() != null){
            livro = livroAutorDTOService.findLivroAutorDTOById(emprestimo.getLivroId());
            user = userService.findUserById(emprestimo.getUserId());
            funcionario = funcionarioService.findFuncionarioById(emprestimo.getFuncionarioId());
        }

        return new ModelAndView("biblioteca/emprestimo/edit")
            .addObject("emprestimo", emprestimo)
            .addObject("livro", livro)
            .addObject("user", user)
            .addObject("funcionario", funcionario);
    }
    
    @PostMapping("/new")
    public String post(Emprestimo emprestimo){
        emprestimoService.save(emprestimo);;
        
        return "emprestimo/list";
    }
    
}
