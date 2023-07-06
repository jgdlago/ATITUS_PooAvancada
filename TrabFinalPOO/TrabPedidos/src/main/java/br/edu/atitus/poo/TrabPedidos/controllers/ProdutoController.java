package br.edu.atitus.poo.TrabPedidos.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.TrabPedidos.entities.Produto;
import br.edu.atitus.poo.TrabPedidos.services.GenericService;
import br.edu.atitus.poo.TrabPedidos.services.ProdutoService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/produtos")
public class ProdutoController extends GenericController<Produto>{

	private final ProdutoService produtoService;
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}
	
	@Override
	GenericService<Produto> getService() {
		return produtoService;
	}
	
}
