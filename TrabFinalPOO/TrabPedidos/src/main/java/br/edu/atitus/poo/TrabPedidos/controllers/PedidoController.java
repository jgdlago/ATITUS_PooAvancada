package br.edu.atitus.poo.TrabPedidos.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.TrabPedidos.entities.Pedido;
import br.edu.atitus.poo.TrabPedidos.services.GenericService;
import br.edu.atitus.poo.TrabPedidos.services.PedidoService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/pedidos")
public class PedidoController extends GenericController<Pedido> {

	private final PedidoService pedidoService;
	public PedidoController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}
	
	@Override
	GenericService<Pedido> getService() {
		return pedidoService;
	}
	
}
