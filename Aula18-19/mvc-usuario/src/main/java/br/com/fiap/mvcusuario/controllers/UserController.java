package br.com.fiap.mvcusuario.controllers;

import br.com.fiap.mvcusuario.dtos.UserDTO;
import br.com.fiap.mvcusuario.models.User;
import br.com.fiap.mvcusuario.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/form")
    public String loadForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "usuario/novo-usuario";
    }

    @PostMapping()
    public String insert(@Valid UserDTO userDTO,
                         BindingResult result,
                         RedirectAttributes attributes) {
        if(result.hasErrors()){
            return "/usuario/novo-usuario";
        }
        service.insert(userDTO);
        attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso");
        return "redirect:/users/form";
    }

    @GetMapping()
    public String findAll(Model model) {
        List<UserDTO> users = service.findAll();
        model.addAttribute("users", users);
        return "/usuario/listar-usuarios";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        UserDTO user = service.findById(id);
        model.addAttribute("userDTO", user);
        return "/usuario/editar-usuario";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid UserDTO userDTO,
                         BindingResult result) {
        if(result.hasErrors()) {
            userDTO.setId(id);
            return "/usuario/editar-usuario";
        }
        service.update(userDTO);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String delete(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        return "redirect:/users";
    }


}
