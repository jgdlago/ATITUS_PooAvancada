package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Produto;
import br.edu.atitus.pooavancado.CadUsuario.repositories.ProdutoRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto buscarProdutoPorId(int id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public void adicionarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public void atualizarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public void removerProduto(int id) {
        produtoRepository.deleteById(id);
    }
}

