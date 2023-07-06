package br.edu.atitus.poo.TrabPedidos.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.TrabPedidos.entities.Usuario;
import br.edu.atitus.poo.TrabPedidos.services.GenericService;
import br.edu.atitus.poo.TrabPedidos.services.UsuarioService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/usuarios")
public class UsuarioController extends GenericController<Usuario>{

	final UsuarioService usuarioService;
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@Override
	GenericService<Usuario> getService() {
		return usuarioService;
	}

}
