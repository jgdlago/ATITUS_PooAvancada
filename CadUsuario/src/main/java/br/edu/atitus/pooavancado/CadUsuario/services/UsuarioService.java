package br.edu.atitus.pooavancado.CadUsuario.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;

public interface UsuarioService {
	
	Usuario save(Usuario usuario) throws Exception;
	
	Optional<Usuario> findById(Long id) throws Exception;
	
	void deleteByid(Long id) throws Exception;

	Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable) throws Exception;
	
	void alteraStatus(long id) throws Exception;
}
