package br.edu.atitus.pooavancado.CadUsuario.controllers;

import java.security.SecureRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.configs.JwtUtils;
import br.edu.atitus.pooavancado.CadUsuario.controllers.payloads.SigninPayload;
import br.edu.atitus.pooavancado.CadUsuario.controllers.payloads.SignupPayload;
import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;
import ch.qos.logback.core.subst.Token;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;
	private final UsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;
	public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtils = jwtUtils;
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
	}


	@PostMapping("/signin")
	public ResponseEntity<Object> signin(@RequestBody SigninPayload login) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);			
			
			String token = jwtUtils.generateTokenFromEmail(login.getEmail());
			return ResponseEntity.status(HttpStatus.OK).body(token);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
		
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody SignupPayload signup) {
		try {
			Usuario usuarioNovo = new Usuario();
			usuarioNovo.setNome(signup.getNome());
			usuarioNovo.setEmail(signup.getEmail());
			usuarioNovo.setStatus(true);
			
			String novaSenha = gerarSenhaAleatoria(10);
			usuarioNovo.setSenha(passwordEncoder.encode(novaSenha));
			
			usuarioService.save(usuarioNovo);
			return ResponseEntity.status(HttpStatus.OK).body(novaSenha);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	private String gerarSenhaAleatoria(int tamanho) {
		String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=";
		SecureRandom random = new SecureRandom();
		StringBuilder senha = new StringBuilder(tamanho);
		
		for (int i = 0; i < tamanho; i ++) {
			int indice = random.nextInt(CARACTERES_PERMITIDOS.length());
			senha.append(CARACTERES_PERMITIDOS.charAt(indice));
		}
		return senha.toString();
	}
}
