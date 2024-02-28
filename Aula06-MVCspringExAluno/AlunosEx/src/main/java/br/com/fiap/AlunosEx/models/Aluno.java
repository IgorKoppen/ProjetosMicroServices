package br.com.fiap.AlunosEx.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;
    @NotBlank(message = "Nome não pode ser vazio!")
   String nome;

    @Email(message = "Email deve ser valido!")
    @NotBlank(message = "Nome não pode ser vazio!")
   String email;

    @NotBlank(message = "Nome não pode ser vazio!")
    @Max(6)
   String rm;
    @NotBlank(message = "Nome não pode ser vazio!")
   String turma;

    public Aluno(String nome, String email, String rm, String turma) {
        this.nome = nome;
        this.email = email;
        this.rm = rm;
        this.turma = turma;
    }

    public Aluno() {
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

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", rm='" + rm + '\'' +
                ", turma='" + turma + '\'' +
                '}';
    }
}
