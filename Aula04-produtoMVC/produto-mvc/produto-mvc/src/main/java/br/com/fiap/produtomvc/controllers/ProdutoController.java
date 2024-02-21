package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping
    public String adicionaProduto() {
        return "produto/novo-produto";
    }
    @PostMapping
    public String insertProduto(){
        return "redirect:/produtos";
    }

}
