package br.edu.atitus.pooavancado.CadUsuario.servicesImple;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.entities.Departamento;
import br.edu.atitus.pooavancado.CadUsuario.repositories.DepartamentoRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.DepartamentoService;

@Service
public class DepartamentoServiceImple implements DepartamentoService{
	
	private final DepartamentoRepository departamentoRepository;
	public DepartamentoServiceImple(DepartamentoRepository departamentoRepository) {
		super();
		this.departamentoRepository = departamentoRepository;
	}
	
	private boolean existsByNomeAndIdNot(String nome, Long id) {
		return this.departamentoRepository.existsByNomeAndIdNot(nome, id);
	}
	
	@Override
	public Departamento save(Departamento departamento) throws Exception {
		if (this.existsByNomeAndIdNot(departamento.getNome(), departamento.getId())) {
			throw new Exception("Já existe registro");
		}
		return this.departamentoRepository.save(departamento);
	}

	@Override
	public Optional<Departamento> findById(Long id) throws Exception {
		return this.departamentoRepository.findById(id);
	}

	@Override
	public void deleteByid(Long id) throws Exception {
		if (!this.departamentoRepository.existsById(id)) {
			throw new Exception("Não existe registro com este id");
		}
		this.departamentoRepository.deleteById(id);
	}

	@Override
	public Page<Departamento> findByNomeContainingIgnoreCase(String nome, Pageable pageable) throws Exception {
		return this.departamentoRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}

}
