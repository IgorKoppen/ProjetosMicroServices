package br.com.fiap.produtomvc.dtos;

import br.com.fiap.produtomvc.models.Loja;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LojaDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    public LojaDTO(Loja entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LojaDTO lojaDTO = (LojaDTO) o;
        return Objects.equals(id, lojaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "LojaDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
