package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repositories.ProdutoRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;
    @GetMapping("/novo")
    public String adicionaProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produto/novo-produto";
    }
    @PostMapping("/salvar")
    public String insertProduto(@Valid Produto produto, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()) {
            return "/produto/novo-produto";
        }
        repository.save(produto);
        attributes.addFlashAttribute("mensagem","Produto salvo com sucesso");
        return "redirect:/produtos/novo";
    }

}
