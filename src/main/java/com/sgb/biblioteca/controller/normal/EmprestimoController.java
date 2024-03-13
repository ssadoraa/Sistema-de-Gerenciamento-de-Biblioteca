package com.sgb.biblioteca.controller.normal;

import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgb.biblioteca.model.Emprestimo;
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
    
    @GetMapping()
    public ModelAndView list() {
        val emprestimos = emprestimoService.listagemEmprestimos();
        return new ModelAndView("biblioteca/emprestimo/list")
        .addObject("emprestimos", emprestimos);
    }

    @GetMapping("/aberto")
    public ModelAndView listAbertos() {
        val emprestimos = emprestimoService.listagemEmprestimosAbertos();
        return new ModelAndView("biblioteca/emprestimo/abertos/list")
        .addObject("emprestimos", emprestimos);
    }
    
    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {
        val emprestimo = emprestimoService.findEmprestimoComDependenciaById(id);
        return new ModelAndView("biblioteca/emprestimo/get")
            .addObject("emprestimo", emprestimo);
    }

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
        UserModel funcionario = null;

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
    public String post(Emprestimo emprestimo, RedirectAttributes redirectAttributes){
        emprestimoService.save(emprestimo);;
        redirectAttributes.addAttribute("id", emprestimo.getId());
        return "emprestimo/list";
    }
    
    @PostMapping("/encerrar")
    public String encerrar(Long id, RedirectAttributes redirectAttributes){
        val emprestimo = emprestimoService.encerrarEmprestimo(id);
        redirectAttributes.addAttribute("id", emprestimo.getId());
        redirectAttributes.addFlashAttribute("mensagem", "Empréstimo encerrado com sucesso!");
        return "redirect:/emprestimo/{id}";
    }
}
