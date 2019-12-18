package com.ulisses.desafio.service;

import java.util.List;
import java.util.Optional;

import com.ulisses.desafio.model.entity.Cliente;

public interface ClienteService {
	Cliente salvar(Cliente cliente);
	
	Cliente atualizar(Cliente cliente);
	
	void deletar(Cliente cliente);
	
	List<Cliente> buscar(Cliente cliente);

	void validar(Cliente cliente);

	void validaClienteJaCadastrado(String cpf);
	
	Optional<Cliente> obterPorId(Long id);
	
}
