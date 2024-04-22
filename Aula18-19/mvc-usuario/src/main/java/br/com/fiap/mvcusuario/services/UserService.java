package br.com.fiap.mvcusuario.services;

import br.com.fiap.mvcusuario.dtos.UserDTO;
import br.com.fiap.mvcusuario.models.User;
import br.com.fiap.mvcusuario.repositories.UserRepository;
import org.modelmapper.ModelMapper;
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

    ModelMapper modelMapper = new ModelMapper();

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        List<UserDTO> usersDTO = users.stream().map(user-> userToUserDTO(user)).collect(Collectors.toList());
        return usersDTO;
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user =repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado")
        );
        return userToUserDTO(user);
    }

    @Transactional
    public UserDTO insert(UserDTO userdto) {
        User user = modelMapper.map(userdto,User.class);
        user.setMoment(Instant.now());
        return userToUserDTO(repository.save(user));
    }

    @Transactional
    public UserDTO update(UserDTO userdto) {
        User findedUser = repository.getReferenceById(userdto.getId());
        findedUser.setNome(userdto.getNome());
        findedUser.setSenha(userdto.getSenha());
        findedUser.setEmail(userdto.getEmail());
        findedUser.setDataNascimento(userdto.getDataNascimento());
        return userToUserDTO(repository.save(findedUser));
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private UserDTO userToUserDTO(User user){
        return modelMapper.map(user,UserDTO.class);
    }
    private User UserDTOtoUser(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }
}
