package br.edu.atitus.pooavancado.CadUsuario.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/status")
public class StatusController {
	
	@GetMapping
	public ResponseEntity<String> getHelloWorld() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
	}
}
