package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//URL - localhost:8080/produtos
//código omitido
@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    //injeção de pedendência
    @Autowired
    private ProdutoRepository repository;

    //URL - localhost:8080/produtos/novo
    @GetMapping("/novo")
    public String adicionarProduto(Model model){

        model.addAttribute("produto", new Produto());
        //model -> enviar o obj. Produto para a view
        return "produto/novo-produto";
    } //código omitido

    // código omitido
    // receber dados do form da View novo-produto.html
    //URL - localhost:8080/produtos/salvar
    @PostMapping("/salvar")
    public String insertProduto(@Valid Produto produto, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()) {
            return "/produto/novo-produto";
        }
        repository.save(produto);
        attributes.addFlashAttribute("mensagem","Produto salvo com sucesso");
        return "redirect:/produtos/novo";
    }
    @GetMapping("/listarProdutos")
    public String listarProdutos(Model model){
        model.addAttribute("produtos",repository.findAll());
        return "/produto/listar-produtos";
    }
    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable Long id){
        repository.deleteById(id);
        return "redirect:/produtos/listarProdutos";
    }
    @PostMapping("/alterar")
    public String alterarProdutosPage(@Valid Produto produto,Model model){
            model.addAttribute("produto", produto);
            return "/produto/alterar-produto";
        }

    @PutMapping("/alterarSalvar")
    public String alterarProdutos(@Valid Produto produto, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()) {
            return "/produto/alterar-produto";
        }
        repository.save(produto);
        attributes.addFlashAttribute("mensagem","Produto salvo com sucesso");
        return "redirect:/produtos/listarProdutos";
    }
}











