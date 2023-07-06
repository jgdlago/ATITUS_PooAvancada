package br.edu.atitus.poo.TrabPedidos.servicesImple;

import org.springframework.stereotype.Service;

import br.edu.atitus.poo.TrabPedidos.entities.Pedido;
import br.edu.atitus.poo.TrabPedidos.repositories.GenericRepository;
import br.edu.atitus.poo.TrabPedidos.repositories.PedidoRepository;
import br.edu.atitus.poo.TrabPedidos.services.PedidoService;

@Service
public class PedidoServiceImple implements PedidoService {
	
	private final PedidoRepository pedidoRepository;
	public PedidoServiceImple(PedidoRepository pedidoRepository) {
		super();
		this.pedidoRepository = pedidoRepository;
	}
	
	@Override
	public GenericRepository<Pedido> getRepository() {
		return pedidoRepository;
	}
	
}
