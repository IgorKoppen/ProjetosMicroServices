package br.com.fiap.mvcusuario.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;

public class UserDTO{
        private Long id;
        @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
        private String nome;
        @Email(message = "Email inválido")
        @NotBlank(message = "Campo requerido")
        private String email;
        @NotNull(message = "Campo requerido")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataNascimento;
        private Instant moment;
        @NotBlank(message = "Campo requerido")
        @Size(min = 8, message = "A senha deve ter no minimo 8 caracteres")
        private String senha;

        public UserDTO(String nome, String email, @NotNull(message = "Campo requerido") LocalDate dataNascimento, Instant moment, String senha) {
                this.nome = nome;
                this.email = email;
                this.dataNascimento = dataNascimento;
                this.moment = moment;
                this.senha = senha;
        }

        public UserDTO() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public LocalDate getDataNascimento() {
                return dataNascimento;
        }

        public void setDataNascimento(LocalDate dataNascimento) {
                this.dataNascimento = dataNascimento;
        }

        public Instant getMoment() {
                return moment;
        }

        public void setMoment(Instant moment) {
                this.moment = moment;
        }

        public String getSenha() {
                return senha;
        }

        public void setSenha(String senha) {
                this.senha = senha;
        }
}
