package com.datapar.front_gestao_satisfacao.modules.usuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datapar.front_gestao_satisfacao.modules.usuario.entity.Form;
import com.datapar.front_gestao_satisfacao.modules.usuario.service.FormService;

@Controller
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/")
    public String formInicial(){
        return "usuario/form";
    }

    @PostMapping("/validate")
    public String validaForm(RedirectAttributes redirectAttributes, Form form){

        try{
            
            var msg = this.formService.execute(form);

            redirectAttributes.addFlashAttribute("success_message", msg);
            return "redirect:/form/";

        } catch (HttpClientErrorException e) {
            redirectAttributes.addFlashAttribute("error_message", msg);
            return "redirect:/form/";
        }

    }

}
