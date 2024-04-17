package br.com.fiap.mvcusuario.repositories;

import br.com.fiap.mvcusuario.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
