package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.dtos.CategoriaDTO;
import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    // Injeção de dependência de repository
    @Autowired
    private CategoriaRepository repository;

    //Método que retorna uma lista de Categoria
    @Transactional(readOnly = true)
    public List<CategoriaDTO> findAll() {
        List<Categoria> categorias = repository.findAll();
        return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    }

    //Método para inserir Categoria
    @Transactional
    public CategoriaDTO insert(CategoriaDTO categoriaDTO) {
        Categoria categoriaEntity = new Categoria();
        dtoToEntity(categoriaDTO,categoriaEntity);
        categoriaEntity = repository.save(categoriaEntity);
        return  new CategoriaDTO(categoriaEntity);
    }

    //Método para buscar Categoria por Id
    @Transactional(readOnly = true)
    public CategoriaDTO findById(Long id) {

        Categoria categoria = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return new CategoriaDTO(categoria);
    }

    //Método para atualiza Categoria
    @Transactional
    public CategoriaDTO update(Long id, CategoriaDTO categoriaDTO) {
        try {
            Categoria categoria = repository.getReferenceById(id);
            dtoToEntity(categoriaDTO, categoria);
            categoria = repository.save(categoria);
            return new CategoriaDTO(categoria);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    // Método para excluir categoria
    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Falha de integridade referencial - id: " + id);
        }
    }

    //Método para copiar dados entre objetos
    private void dtoToEntity(CategoriaDTO dto, Categoria categoria) {
        categoria.setNome(dto.getNome());
    }


}



