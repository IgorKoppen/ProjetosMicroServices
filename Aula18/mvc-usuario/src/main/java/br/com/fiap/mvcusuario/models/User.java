package br.com.fiap.mvcusuario.models;

import br.com.fiap.mvcusuario.dtos.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tb_user")
public class User {

    public User(UserDTO userDTO) {
        this.id = userDTO.id();
        this.nome = userDTO.nome();
        this.email = userDTO.email();
        this.dataNascimento = userDTO.dataNascimento();
        this.moment = userDTO.moment();
        this.senha = userDTO.senha();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private LocalDate dataNascimento;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    private String senha;

}
