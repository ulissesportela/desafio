package com.ulisses.desafio.service;

import java.util.List;

import com.ulisses.desafio.api.dto.EmailDTO;
import com.ulisses.desafio.model.entity.Email;

public interface EmailService {

	Email salvar(Email email);
	
	void apagarVinculo(Long clienteId);
	
	List<EmailDTO> lista(Long clienteId);
	
}
