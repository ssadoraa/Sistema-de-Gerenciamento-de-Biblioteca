package com.sgb.biblioteca.controller.normal;

import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.sgb.biblioteca.model.Emprestimo;
import com.sgb.biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private EmprestimoService emprestimoService;

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
        return new ModelAndView("biblioteca/emprestimo/edit")
            .addObject("emprestimo", emprestimo);
    }
    
    @PostMapping("/new")
    public String post(Emprestimo emprestimo){
        emprestimoService.save(emprestimo);;
        
        return "emprestimo/list";
    }
    
}
