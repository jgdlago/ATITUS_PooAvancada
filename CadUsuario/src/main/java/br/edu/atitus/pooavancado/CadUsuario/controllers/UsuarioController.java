package br.edu.atitus.pooavancado.CadUsuario.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

	List<Usuario> listaUsuario = new ArrayList<>();
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(listaUsuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		for (Usuario usuario : listaUsuario) {
			if (usuario.getId() == id) {
				return ResponseEntity.status(HttpStatus.OK).body(usuario);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe");
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Usuario usuario) {
		listaUsuario.add(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> saveUpdate(@PathVariable long id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	
}
