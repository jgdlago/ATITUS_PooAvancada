package br.edu.atitus.pooavancado.CadUsuario.entities;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends GenericEntity implements GrantedAuthority {

	@Override
	public String getAuthority() {
		return this.getNome();
	}
	
}
