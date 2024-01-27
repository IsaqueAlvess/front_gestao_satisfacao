package com.datapar.front_gestao_satisfacao.modules.usuario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UsuarioController {
    
    @GetMapping("/login")
    public String login(){
        return "usuario/login";
    }

    @GetMapping("/form")
    public String form(){
        return "usuario/form";
    }

    @GetMapping("/profile")
    public String profile(){
        return "usuario/profile";
    }


}
