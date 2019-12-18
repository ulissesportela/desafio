package com.ulisses.desafio.service;

import com.ulisses.desafio.model.entity.Usuario;

public interface UsuarioService {

	Usuario autenticar(String login, String senha);
	
}
