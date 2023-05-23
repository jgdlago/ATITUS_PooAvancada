package br.edu.atitus.pooavancado.CadUsuario.repositories;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}

