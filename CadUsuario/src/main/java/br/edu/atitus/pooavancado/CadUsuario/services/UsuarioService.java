package br.edu.atitus.pooavancado.CadUsuario.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;

public interface UsuarioService extends GenericService<Usuario>, UserDetailsService {
		
	void alteraStatus(long id) throws Exception;
}
