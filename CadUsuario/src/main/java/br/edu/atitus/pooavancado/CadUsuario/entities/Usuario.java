package br.edu.atitus.pooavancado.CadUsuario.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 150, nullable = true)
	private String email;
	
	@Column(nullable = false)
	private boolean status;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
