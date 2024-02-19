package br.com.fiap.hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class homeController {

@GetMapping()
    public String mostrarMensagem(@RequestParam(name = "nome", required = false, defaultValue = "Fiap")  String nome, Model model){
    model.addAttribute("nome",nome);
    return "view/hello";
}



}
