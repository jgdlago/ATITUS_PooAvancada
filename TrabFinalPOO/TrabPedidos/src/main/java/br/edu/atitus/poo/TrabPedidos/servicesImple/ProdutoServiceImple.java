package br.edu.atitus.poo.TrabPedidos.servicesImple;

import org.springframework.stereotype.Service;

import br.edu.atitus.poo.TrabPedidos.entities.Produto;
import br.edu.atitus.poo.TrabPedidos.repositories.GenericRepository;
import br.edu.atitus.poo.TrabPedidos.repositories.ProdutoRepository;
import br.edu.atitus.poo.TrabPedidos.services.ProdutoService;

@Service
public class ProdutoServiceImple implements ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	public ProdutoServiceImple(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public GenericRepository<Produto> getRepository() {
		return produtoRepository;
	}
	
}
