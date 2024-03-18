package com.sgb.biblioteca.controller.rest;

import org.springframework.web.bind.annotation.RestController;

import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.service.UserService;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/api/funcionarios")
public class FuncionarioRestController {

    private final UserService userService;
    
    @GetMapping
    @ResponseBody
    public List<UserModel> findByQuery(@RequestParam String busca){
        return userService.findFuncionarioByQuery(busca);
    }

}