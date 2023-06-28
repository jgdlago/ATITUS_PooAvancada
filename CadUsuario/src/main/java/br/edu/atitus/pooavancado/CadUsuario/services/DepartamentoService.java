package br.edu.atitus.pooavancado.CadUsuario.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.CadUsuario.entities.Departamento;

public interface DepartamentoService {
	
	Departamento save(Departamento departamento) throws Exception;
	
	Optional<Departamento> findById(Long id) throws Exception;
	
	void deleteByid(Long id) throws Exception;

	Page<Departamento> findByNomeContainingIgnoreCase(String nome, Pageable pageable) throws Exception;
	
}
