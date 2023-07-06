package br.edu.atitus.poo.TrabPedidos.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.edu.atitus.poo.TrabPedidos.entities.Usuario;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario> {

	Optional<Usuario> findByEmail(String email);
}
