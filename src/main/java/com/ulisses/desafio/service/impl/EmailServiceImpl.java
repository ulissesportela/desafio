package com.ulisses.desafio.service.impl;
import com.ulisses.desafio.api.dto.EmailDTO;
import com.ulisses.desafio.model.entity.Email;
import com.ulisses.desafio.model.repository.EmailRepository;
import com.ulisses.desafio.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository repository;

	@Override
	public Email salvar(Email email) {
        return repository.save(email);
	}

	@Override
	public void apagarVinculo(Long clienteId) {
		repository.apagarVinculo(clienteId);
	}

	@Override
	public List<EmailDTO> lista(Long clienteId) {
		return repository.lista(clienteId);
	}
    
}
