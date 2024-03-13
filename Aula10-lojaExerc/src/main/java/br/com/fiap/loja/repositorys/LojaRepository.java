package br.com.fiap.loja.repositorys;

import br.com.fiap.loja.models.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja,Long> {
}
