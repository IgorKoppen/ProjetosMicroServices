package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.dtos.CategoriaDTO;
import br.com.fiap.produtomvc.dtos.LojaDTO;
import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.models.Loja;
import br.com.fiap.produtomvc.repository.LojaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;


    @Transactional(readOnly = true)
    public List<LojaDTO> findAll() {
        List<Loja> loja = repository.findAll();
        return loja.stream().map(LojaDTO::new).collect(Collectors.toList());
    }

    //Método para inserir Produto
    @Transactional
    public LojaDTO insert(LojaDTO lojaDTO) {
        Loja lojaEntity = new Loja();
        dtoToEntity(lojaDTO,lojaEntity);
        lojaEntity = repository.save(lojaEntity);
        return  new LojaDTO(lojaEntity);
    }

    //Método para buscar Produto por Id
    @Transactional(readOnly = true)
    public LojaDTO findById(Long id) {

        Loja loja = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return new LojaDTO(loja);
    }

    @Transactional
    public LojaDTO update(Long id, LojaDTO entity) {
        try {
            Loja loja = repository.getReferenceById(id);
            dtoToEntity(entity, loja);
            loja = repository.save(loja);
            return new LojaDTO(loja);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    // Método para excluir Produto
    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Loja inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (Exception e){
            throw new IllegalArgumentException("Loja inválido - id: " + id);
        }
    }

    private void dtoToEntity(LojaDTO dto, Loja loja) {

        loja.setNome(dto.getNome());
    }

}
