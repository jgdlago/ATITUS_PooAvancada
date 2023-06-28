package br.edu.atitus.pooavancado.CadUsuario.services;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;

public interface UsuarioService extends GenericService<Usuario, UsuarioRepository> {
		
	void alteraStatus(long id) throws Exception;
}
