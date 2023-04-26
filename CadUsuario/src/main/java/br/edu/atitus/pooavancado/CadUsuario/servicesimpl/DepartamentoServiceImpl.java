package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import java.util.Optional;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Departamento;
import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.DepartamentoRespository;
import br.edu.atitus.pooavancado.CadUsuario.services.DepartamentoService;

public class DepartamentoServiceImpl implements DepartamentoService{
	
	final DepartamentoRespository departamentoRespository;
	
	public DepartamentoServiceImpl(DepartamentoRespository departamentoRespository) {
		super();
		this.departamentoRespository = departamentoRespository;
	}
	
	@Override
	public Departamento save(Departamento departamento) throws Exception {
		return departamentoRespository.save(departamento);
	}

	@Override
	public Optional<Departamento> findById(long id) {
		return departamentoRespository.findById(id);
	}
	
	@Override
	public void deleteById(long id) {
		departamentoRespository.deleteById(id);
	}
}
