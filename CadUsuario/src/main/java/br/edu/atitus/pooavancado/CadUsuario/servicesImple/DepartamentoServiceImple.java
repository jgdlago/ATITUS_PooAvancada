package br.edu.atitus.pooavancado.CadUsuario.servicesImple;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.repositories.DepartamentoRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.DepartamentoService;

@Service
public class DepartamentoServiceImple implements DepartamentoService{
	
	private final DepartamentoRepository departamentoRepository;
	public DepartamentoServiceImple(DepartamentoRepository departamentoRepository) {
		super();
		this.departamentoRepository = departamentoRepository;
	}
	
	@Override
	public DepartamentoRepository getRepository() {
		return departamentoRepository;
	}
}
