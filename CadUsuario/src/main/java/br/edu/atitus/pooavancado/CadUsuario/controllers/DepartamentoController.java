package br.edu.atitus.pooavancado.CadUsuario.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.entities.Departamento;
import br.edu.atitus.pooavancado.CadUsuario.services.DepartamentoService;


@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("departamento")
public class DepartamentoController { 
	
	@Autowired
	private DepartamentoService departamentoService;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Departamento departamento) {
		try {
			departamentoService.save(departamento);
			return ResponseEntity.status(HttpStatus.CREATED).body(departamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll(@RequestParam String nome,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		try {
			Page<Departamento> departamentosLista = departamentoService.findByNomeContainingIgnoreCase(nome, pageable);
			return ResponseEntity.status(HttpStatus.OK).body(departamentosLista);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		try {
			Optional<Departamento> departamento = departamentoService.findById(id);
			if (departamento.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe usuário com id "+id);
			}
			return ResponseEntity.status(HttpStatus.OK).body(departamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> saveUpdate(@PathVariable long id, @RequestBody Departamento departamento) {
		try {
			departamento.setId(id);
			departamentoService.save(departamento);
			return ResponseEntity.status(HttpStatus.OK).body(departamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		try {			
			departamentoService.deleteByid(id);
			return ResponseEntity.status(HttpStatus.OK).body("departamento deletado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}	
}
