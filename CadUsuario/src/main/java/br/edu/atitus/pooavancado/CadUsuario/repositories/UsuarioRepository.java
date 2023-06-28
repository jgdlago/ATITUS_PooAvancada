package br.edu.atitus.pooavancado.CadUsuario.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	boolean existsByNomeAndIdNot(String nome, Long id);

	Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	
	@Query(value = "update usuario set status = not status where id = :id", nativeQuery = true)
	@Modifying
	@Transactional
	void alteraStatus(long id);
}
