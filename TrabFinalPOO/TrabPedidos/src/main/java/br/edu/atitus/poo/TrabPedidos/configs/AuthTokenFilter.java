package br.edu.atitus.poo.TrabPedidos.configs;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.edu.atitus.poo.TrabPedidos.services.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthTokenFilter extends OncePerRequestFilter{

	private final JwtUtils jwtUtils;
	private final UsuarioService usuarioService;
	public AuthTokenFilter(JwtUtils jwtUtils, UsuarioService usuarioService) {
		super();
		this.jwtUtils = jwtUtils;
		this.usuarioService = usuarioService;
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		try {
			String bearerToken = jwtUtils.getBearerTokenFromRequest(request);
			if (bearerToken != null && jwtUtils.validateJwtToken(bearerToken)) {
				String email = jwtUtils.getEmailFromJwtToken(bearerToken);
				UserDetails user = usuarioService.loadUserByUsername(email);
				UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
				userAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userAuth);
			}
		} catch (Exception e) {
		}
		filterChain.doFilter(request, response);
	}
}
