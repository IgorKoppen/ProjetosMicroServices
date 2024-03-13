package br.com.fiap.loja.controllers;

import br.com.fiap.loja.models.Loja;
import br.com.fiap.loja.repositorys.LojaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;


    @GetMapping("/novo")
    @Transactional(readOnly = true)
    public String adicionarProduto(Model model) {
        model.addAttribute("loja", new Loja());
        return "views/novo-loja";
    }

    @PostMapping("/salvar")
    @Transactional
    public String novaLoja(@Valid Loja loja, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "/views/novo-loja";
        }
        lojaRepository.save(loja);
        attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso");
        return "redirect:/lojas/novo";
    }
    @GetMapping("/listar")
    @Transactional(readOnly = true)
    public String listarLoja(Model model) {
        model.addAttribute("lojas", lojaRepository.findAll());
        return "/views/listar-lojas";
    }
    @GetMapping("/deletar/{id}")
    @Transactional
    public String excluirLoja(@PathVariable Long id) {
        if(!lojaRepository.existsById(id)){
            throw new IllegalArgumentException("Loja inválido - id: " + id);
        }
        try {
            lojaRepository.deleteById(id);
        }catch (Exception e){
            throw new IllegalArgumentException("Loja inválido - id: " + id);
        }
        lojaRepository.deleteById(id);
        return "redirect:/lojas/listar";
    }

    @GetMapping("/editar/{id}")
    @Transactional(readOnly = true)
    public String editarLojaPage(@PathVariable("id") Long id, Model model) {
        Optional<Loja> loja = lojaRepository.findById(id);
        if (loja.isEmpty()) {
            throw new IllegalArgumentException("Loja inválido - id: " + id);
        }
        model.addAttribute("loja", loja.get());
        return "/views/editar-loja";
    }

    @PostMapping("/editar/{id}")
    @Transactional
    public String editarLoja(@PathVariable("id") Long id, @Valid Loja loja, BindingResult result) {
        if (result.hasErrors()) {
            loja.setId(id);
            return "/views/editar-loja";
        }
        lojaRepository.save(loja);
        return "redirect:/lojas/listar";
    }

}
