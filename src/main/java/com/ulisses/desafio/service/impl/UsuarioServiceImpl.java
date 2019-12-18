package com.ulisses.desafio.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ulisses.desafio.exception.ErroAutenticacao;
import com.ulisses.desafio.model.entity.Usuario;
import com.ulisses.desafio.model.repository.UsuarioRepository;
import com.ulisses.desafio.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	
	private UsuarioRepository repository;
	
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String login, String senha) {
		Optional<Usuario> usuario =  repository.findByLogin(login);
		
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuario não encontrado para o login informado.");
		}
		
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida.");
		}
		
		return usuario.get();
	}


}
