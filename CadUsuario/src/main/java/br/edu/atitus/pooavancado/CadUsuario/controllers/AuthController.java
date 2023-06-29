package br.edu.atitus.pooavancado.CadUsuario.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.configs.JwtUtils;
import br.edu.atitus.pooavancado.CadUsuario.controllers.payloads.SigninPayload;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;
	public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtils = jwtUtils;
	}


	@PostMapping("*/signin")
	public ResponseEntity<Object> signin(@RequestBody SigninPayload login) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtUtils.generateTokenFromEmail(login.getEmail());
		return ResponseEntity.status(HttpStatus.OK).body(token);
	}
}
