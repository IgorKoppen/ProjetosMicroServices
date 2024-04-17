package br.com.fiap.mvcusuario.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;

public record UserDTO(
        Long id,
        @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
        String nome,
        @Email(message = "Email inválido")
        @NotBlank(message = "Campo requerido")
        String email,
        @NotNull(message = "Campo requerido")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        Instant moment,
        @NotBlank(message = "Campo requerido")
        @Size(min = 8, message = "A senha deve ter no minimo 8 caracteres")
        String senha) {
}
