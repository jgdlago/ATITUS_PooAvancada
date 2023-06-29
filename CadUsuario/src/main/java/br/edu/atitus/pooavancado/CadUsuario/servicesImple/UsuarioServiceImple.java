package br.edu.atitus.pooavancado.CadUsuario.servicesImple;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;

@Service
public class UsuarioServiceImple implements UsuarioService{
	
	private final UsuarioRepository usuarioRepository;
	public UsuarioServiceImple(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UsuarioRepository getRepository() {
		return usuarioRepository;
	}
	
	@Override
	public void alteraStatus(long id) throws Exception {
		if (!this.usuarioRepository.existsById(id)) {
			throw new Exception("Não existe registro com este id");
		}
		this.usuarioRepository.alteraStatus(id);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		return usuario;
	}

}
