package br.edu.atitus.pooavancado.CadUsuario.services;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Produto;

import java.util.List;

public interface ProdutoService {
	
    Produto buscarProdutoPorId(int id);
    
    List<Produto> listarProdutos();
    
    void adicionarProduto(Produto produto);
    
    void atualizarProduto(Produto produto);
    
    void removerProduto(int id);
}

