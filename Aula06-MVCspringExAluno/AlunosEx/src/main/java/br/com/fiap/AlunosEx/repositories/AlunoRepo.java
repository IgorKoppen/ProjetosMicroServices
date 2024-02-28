package br.com.fiap.AlunosEx.repositories;

import br.com.fiap.AlunosEx.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepo extends JpaRepository<Aluno, Long> {
}
