package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // This means that this class is a Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        return "menu";
    }

    @GetMapping(path = "/connexion")
    public String connexion(){
        return "connexion";
    }
    @GetMapping(path = "/inscription")
    public String inscription(){
        return "inscription";
    }
    @GetMapping(path = "/menu")
    public String menu(){
        return "menu";
    }
    
}