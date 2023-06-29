package br.edu.atitus.pooavancado.CadUsuario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario>{
		
	@Query(value = "update usuario set status = not status where id = :id", nativeQuery = true)
	@Modifying
	@Transactional
	void alteraStatus(long id);
	
	Optional<Usuario> findByEmail(String email);
}
