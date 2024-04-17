package br.com.fiap.mvcusuario.services;

import br.com.fiap.mvcusuario.dtos.UserDTO;
import br.com.fiap.mvcusuario.models.User;
import br.com.fiap.mvcusuario.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        List<UserDTO> usersDTO = users.stream().map(UserDTO:new).collect(Collectors.toList());
        return usersDTO;
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        User user = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado")
        );
        return user;
    }

    @Transactional
    public User insert(UserDTO userdto) {
        User user = new User(userdto);
        user.setMoment(Instant.now());

        return repository.save(user);
    }

    @Transactional
    public User update(UserDTO userdto) {
        User user = new User(userdto);
        return repository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
