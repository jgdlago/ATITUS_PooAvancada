package br.edu.atitus.pooavancado.CadUsuario.servicesImple;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;
import jakarta.transaction.Transactional;

@Service
@Transactional
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
		return new User(usuario.getEmail(),
				usuario.getPassword(),
				usuario.isEnabled(),
				usuario.isAccountNonExpired(),
				usuario.isCredentialsNonExpired(),
				usuario.isAccountNonLocked(),
				usuario.getAuthorities());
	}

	@Override
	public void validarSave(Usuario usuarioAlvo) throws Exception {
		UsuarioService.super.validarSave(usuarioAlvo);
		
		UserDetails usuarioLogado = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!usuarioLogado.getUsername().equals(usuarioAlvo.getUsername()))
			throw new Exception("Você só pode alterar informações proprias");
	}

}
