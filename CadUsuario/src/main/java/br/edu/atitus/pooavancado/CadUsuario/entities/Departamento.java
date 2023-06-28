package br.edu.atitus.pooavancado.CadUsuario.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento extends GenericEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(length = 150, nullable = true)
	private String email;
	
	@Column(nullable = false)
	private Integer ramal;
	

	public Integer getRamal() {
		return ramal;
	}

	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}
	
}
