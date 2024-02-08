package com.sgb.biblioteca.controller.normal;

import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginPage(){
        return "layout/login";
    }

    @GetMapping("/cadastro")
    public String getCadastroPage(Model model){
        model.addAttribute("user", new UserModel());
        return "biblioteca/usuario/cadastro";
    }

    @PostMapping("/cadastro")
    public String saveUser(UserModel user){
        userService.save(user);
        return "redirect:/login";
    }
}
