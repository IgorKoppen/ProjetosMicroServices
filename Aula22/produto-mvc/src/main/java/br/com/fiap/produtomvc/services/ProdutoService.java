package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.dtos.LojaDTO;
import br.com.fiap.produtomvc.dtos.ProdutoDTO;
import br.com.fiap.produtomvc.models.Loja;
import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    // Injeção de dependência de repository
    @Autowired
    private ProdutoRepository repository;

    //Método que retorna uma lista de Produtos
    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAll() {
        List<Produto> produtos = repository.findAll();
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    //Método para inserir Produto
    @Transactional
    public ProdutoDTO insert(ProdutoDTO produtoDTO) {
        Produto produtoEntity = new Produto();
        copyToProduto(produtoDTO,produtoEntity);
        produtoEntity = repository.save(produtoEntity);
        return  new ProdutoDTO(produtoEntity);
    }

    //Método para buscar Produto por Id
    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id) {

        Produto produto = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return new ProdutoDTO(produto);
    }

    @Transactional
    public ProdutoDTO update(Long id, ProdutoDTO entity) {
        try {
            Produto produto = repository.getReferenceById(id);
            copyToProduto(entity, produto);
            produto = repository.save(produto);
            return new ProdutoDTO(produto);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    // Método para excluir Produto
    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Produto inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (Exception e){
            throw new IllegalArgumentException("Produto inválido - id: " + id);
        }
    }

    private void copyToProduto(ProdutoDTO entity, Produto produto) {
        produto.setNome(entity.getNome());
        produto.setDescricao(entity.getDescricao());
        produto.setValor(entity.getValor());
        produto.setCategoria(entity.getCategoria());
        produto.setLojas(entity.getLojas());
    }


}



