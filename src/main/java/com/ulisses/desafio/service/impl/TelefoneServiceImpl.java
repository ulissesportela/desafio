package com.ulisses.desafio.service.impl;

import com.ulisses.desafio.model.entity.Telefone;
import com.ulisses.desafio.model.repository.TelefoneRepository;
import com.ulisses.desafio.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneServiceImpl implements TelefoneService {

    @Autowired
    private TelefoneRepository repository;

    @Override
    public Telefone salvar(Telefone telefone) {
        return repository.save(telefone);
    }

}
