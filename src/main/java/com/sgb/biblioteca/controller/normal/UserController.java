package com.sgb.biblioteca.controller.normal;

import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        val user = userService.findByIdCamposFormatados(id);
        return new ModelAndView("biblioteca/usuario/edit")
            .addObject("user", user);
    }

    @GetMapping("/new")
    public ModelAndView novo(){
        return new ModelAndView("biblioteca/usuario/cadastro");
    }

    @PostMapping("/new")
    public String saveUser(UserModel user){
        userService.saveNewUser(user);
        return "redirect:/login";
    }
    
    @PostMapping("/edit")
    public String saveUserEdit(UserModel user){
        userService.saveEdit(user);
        return "redirect:/";
    }
}
