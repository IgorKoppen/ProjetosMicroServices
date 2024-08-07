package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.repository.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = false)
    public Categoria insert(Categoria categoria) {
        return repository.save(categoria);
    }

    @Transactional(readOnly = true)
    public Categoria findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
    }

    @Transactional
    public Categoria update(Long id, Categoria entity) {
        try {
            Categoria categoria = repository.getReferenceById(id);
            copyToCategoria(entity, categoria);
            categoria = repository.save(categoria);
            return categoria;
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }
    private void copyToCategoria(Categoria entity, Categoria categoria) {
        categoria.setNome(entity.getNome());
    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Falha de integridade referencial - id: " + id);
        }
    }
}
