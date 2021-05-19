package com.ulisses.desafio.service.impl;

import com.ulisses.desafio.api.dto.TelefoneDTO;
import com.ulisses.desafio.model.entity.Cliente;
import com.ulisses.desafio.model.entity.Telefone;
import com.ulisses.desafio.model.repository.TelefoneRepository;
import com.ulisses.desafio.service.TelefoneService;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefoneServiceImpl implements TelefoneService {

    @Autowired
    private TelefoneRepository repository;

    @Override
    public Telefone salvar(Telefone telefone) {
        return repository.save(telefone);
    }

    
	@Override
	public void apagarVinculo(Long clienteId) {
		repository.apagarVinculo(clienteId);
	}


	@Override
	public List<TelefoneDTO> lista(Long clienteId) {
		return repository.lista(clienteId);
	}


}
