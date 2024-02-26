package com.sgb.biblioteca.controller.normal.util;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@AllArgsConstructor
@RequestMapping("/")
public class MainController {
    
    @GetMapping()
    public ModelAndView get() {
        return new ModelAndView("layout/home");
    }
    
}
