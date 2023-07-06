package br.edu.atitus.poo.TrabPedidos.servicesImple;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.atitus.poo.TrabPedidos.entities.Usuario;
import br.edu.atitus.poo.TrabPedidos.repositories.GenericRepository;
import br.edu.atitus.poo.TrabPedidos.repositories.UsuarioRepository;
import br.edu.atitus.poo.TrabPedidos.services.UsuarioService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImple implements UsuarioService {

	private final UsuarioRepository usuarioRepository;
	public UsuarioServiceImple(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public GenericRepository<Usuario> getRepository() {
		return usuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		return new User(usuario.getEmail(),
				usuario.getPassword(),
				usuario.isEnabled(),
				usuario.isAccountNonExpired(),
				usuario.isCredentialsNonExpired(),
				usuario.isAccountNonLocked(),
				usuario.getAuthorities());
	}
	
	
}
