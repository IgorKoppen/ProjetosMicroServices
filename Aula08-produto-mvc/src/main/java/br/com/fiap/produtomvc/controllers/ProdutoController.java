package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
    @Transactional(readOnly = true)
    public String adicionarProduto(Model model) {

        model.addAttribute("produto", new Produto());
        //model -> enviar o obj. Produto para a view
        return "produto/novo-produto";
    } //código omitido

    // código omitido
    // receber dados do form da View novo-produto.html
    //URL - localhost:8080/produtos/salvar
    @PostMapping("/salvar")
    @Transactional
    public String insertProduto(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "/produto/novo-produto";
        }
        repository.save(produto);
        attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso");
        return "redirect:/produtos/novo";
    }

    @GetMapping("/listarProdutos")
    @Transactional(readOnly = true)
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", repository.findAll());
        return "/produto/listar-produtos";
    }

    @GetMapping("/excluir/{id}")
    @Transactional
    public String excluirProduto(@PathVariable Long id) {
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Produto inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        }catch (Exception e){
            throw new IllegalArgumentException("Produto inválido - id: " + id);
        }
        repository.deleteById(id);
        return "redirect:/produtos/listarProdutos";
    }

    @GetMapping("/editar/{id}")
    @Transactional(readOnly = true)
    public String editarProdutosPage(@PathVariable("id") Long id, Model model) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) {
            throw new IllegalArgumentException("Produto inválido - id: " + id);
        }
        model.addAttribute("produto", produto.get());
        return "/produto/editar-produto";
    }

    @PostMapping("/editar/{id}")
    @Transactional
    public String editarProdutos(@PathVariable("id") Long id, @Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            produto.setId(id);
            return "/produto/editar-produto";
        }
        repository.save(produto);
        return "redirect:/produtos/listarProdutos";
    }


}











