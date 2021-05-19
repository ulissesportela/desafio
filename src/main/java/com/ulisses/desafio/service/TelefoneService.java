package com.ulisses.desafio.service;

import java.util.List;

import com.ulisses.desafio.api.dto.TelefoneDTO;
import com.ulisses.desafio.model.entity.Telefone;

public interface TelefoneService {

    Telefone salvar(Telefone telefone);
    
    void apagarVinculo(Long clienteId);
    
    List<TelefoneDTO> lista(Long clienteId);
    
    
}
