package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping("/novo")
    public String adicionaProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produto/novo-produto";
    }
    @PostMapping("/salvar")
    public String insertProduto(Produto produto){
        System.out.println(produto.toString());
        return "redirect:/produtos/novo";
    }

}
