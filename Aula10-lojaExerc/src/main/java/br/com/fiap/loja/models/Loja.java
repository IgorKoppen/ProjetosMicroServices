package br.com.fiap.loja.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "tb_loja")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O endereco deve ter no mínimo 3 carateres")
    private String endereco;
    @NotBlank(message = "Campo requerido")
    @Size(min = 6, message = "O endereco deve ter no mínimo 6 carateres")
    private String contato;
    @NotBlank(message = "Campo requerido")
    @Size(min = 6, message = "O endereco deve ter no mínimo 6 carateres")
    private String email;
    @NotBlank(message = "Campo requerido")
    @Size(min = 6, message = "O endereco deve ter no mínimo 6 carateres")
    private String telefone;

    public Loja(String nome, String endereco, String contato, String email, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.email = email;
        this.telefone = telefone;
    }

    public Loja() {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loja loja = (Loja) o;
        return id == loja.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
