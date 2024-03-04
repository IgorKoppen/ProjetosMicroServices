package br.com.fiap.AlunosEx.controllers;

import br.com.fiap.AlunosEx.models.Aluno;
import br.com.fiap.AlunosEx.repositories.AlunoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Alunos")
public class AlunoController {
    @Autowired
    private AlunoRepo repository;

    @GetMapping("/novo")
    public String adicionarAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/novo-aluno";
    }
    @PostMapping("/salvar")
    public String insertAluno(Aluno aluno){
        repository.save(aluno);
        return "redirect:/Alunos/novo";
    }

}
