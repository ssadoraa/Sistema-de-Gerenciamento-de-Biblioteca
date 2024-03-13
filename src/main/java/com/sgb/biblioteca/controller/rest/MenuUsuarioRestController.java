package com.sgb.biblioteca.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import com.sgb.biblioteca.model.UserModel;
import com.sgb.biblioteca.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MenuUsuarioRestController {
    
    private UserService userService;

    @GetMapping()
    public UserModel findUser() {
        return userService.findByUsername("isadora");
    }
    
}