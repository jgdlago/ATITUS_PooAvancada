package br.edu.atitus.pooavancado.CadUsuario.servicesImple;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	private boolean existsByNomeAndIdNot(String nome, Long id) {
		return this.usuarioRepository.existsByNomeAndIdNot(nome, id);
	}
	
	@Override
	public Usuario save(Usuario usuario) throws Exception {
		if (this.existsByNomeAndIdNot(usuario.getNome(), usuario.getId())) {
			throw new Exception("Já existe registro");
		}
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findById(Long id) throws Exception {
		return this.usuarioRepository.findById(id);
	}

	@Override
	public void deleteByid(Long id) throws Exception {
		if (!this.usuarioRepository.existsById(id)) {
			throw new Exception("Não existe registro com este id");
		}
		this.usuarioRepository.deleteById(id);
	}

	@Override
	public Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable) throws Exception {
		return this.usuarioRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}

	@Override
	public void alteraStatus(long id) throws Exception {
		if (!this.usuarioRepository.existsById(id)) {
			throw new Exception("Não existe registro com este id");
		}
		this.usuarioRepository.alteraStatus(id);
	}

}
