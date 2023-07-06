package br.edu.atitus.poo.TrabPedidos.services;

import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.atitus.poo.TrabPedidos.entities.Usuario;

@Service
public interface UsuarioService extends GenericService<Usuario>, UserDetailsService {

}
