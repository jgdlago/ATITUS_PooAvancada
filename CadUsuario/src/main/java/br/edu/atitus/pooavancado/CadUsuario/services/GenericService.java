package br.edu.atitus.pooavancado.CadUsuario.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.CadUsuario.entities.GenericEntity;
import br.edu.atitus.pooavancado.CadUsuario.repositories.GenericRepository;

public interface GenericService<
	TEntidade extends GenericEntity,
	TRepository extends GenericRepository<TEntidade>> {

	TRepository getRepository();
	
	default TEntidade save(TEntidade entidade) throws Exception {
		if (this.getRepository().existsByNomeAndIdNot(entidade.getNome(), entidade.getId())) {
			throw new Exception("Já existe registro");
		}
		return this.getRepository().save(entidade);
	}
	
	default Optional<TEntidade> findById(Long id) throws Exception {
		return this.getRepository().findById(id);
	}
	
	default void deleteByid(Long id) throws Exception {
		if (!this.getRepository().existsById(id)) {
			throw new Exception("Não existe registro com este id");
		}
		this.getRepository().deleteById(id);
	}

	default Page<TEntidade> findByNomeContainingIgnoreCase(String nome, Pageable pageable) throws Exception {
		return this.getRepository().findByNomeContainingIgnoreCase(nome, pageable);
	}

}
