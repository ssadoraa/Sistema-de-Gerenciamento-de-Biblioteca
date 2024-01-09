package com.sgb.biblioteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteTelaController {

    @GetMapping("/teste")
    public String greeting() {
        return "testeTela";
    }

}