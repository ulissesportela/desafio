package com.ulisses.desafio.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulisses.desafio.exception.RegraNegocioException;
import com.ulisses.desafio.model.entity.Cliente;
import com.ulisses.desafio.model.entity.Email;
import com.ulisses.desafio.model.entity.Telefone;
import com.ulisses.desafio.model.repository.ClienteRepository;
import com.ulisses.desafio.model.repository.EmailRepository;
import com.ulisses.desafio.model.repository.TelefoneRepository;
import com.ulisses.desafio.service.ClienteService;

@Service
public class ClienteServicoImpl implements ClienteService {

	private ClienteRepository repository;
	private TelefoneRepository telefoneRepository;
	private EmailRepository emailRepository;

	public ClienteServicoImpl(ClienteRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Cliente salvar(Cliente cliente) {
		validar(cliente);
		validaClienteJaCadastrado(cliente.getCpf());
		try {
			return repository.save(cliente);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cliente;
		
	}

	@Override
	public void validaClienteJaCadastrado(String cpf) {
		boolean existe = repository.existsByCpf(cpf);
		if (existe) {
			throw new RegraNegocioException("Já existe um cliente cadastrado com este cpf.");
		}
	}

	@Override
	@Transactional
	public Cliente atualizar(Cliente cliente) {
		Objects.requireNonNull(cliente.getId());
		validar(cliente);
		return repository.save(cliente);
	}

	@Override
	@Transactional
	public void deletar(Cliente cliente) {
		Objects.requireNonNull(cliente.getId());
		repository.delete(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscar(Cliente clienteFiltro) {
		Example example = Example.of( clienteFiltro, 
				ExampleMatcher.matching()
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING) );
		
		return repository.findAll(example);
	}

	@Override
	public void validar(Cliente cliente) {
		
		if(cliente.getNome() == null || cliente.getNome().trim().equals("") || cliente.getNome().toString().length() < 3  || cliente.getNome().toString().length() > 100 ) {
			throw new RegraNegocioException("Informe um nome válido.");
		}
		
		if(cliente.getCpf() == null || cliente.getCpf().toString().length() != 11 ) {
			throw new RegraNegocioException("Informe um cpf válido.");
		}

		//if(cliente.getEmail() == null) {
		//	throw new RegraNegocioException("Informe um email.");
		//}
		
		if(cliente.getLogradouro() == null) {
			throw new RegraNegocioException("Informe um logradouro.");
		}
		
		if(cliente.getBairro() == null) {
			throw new RegraNegocioException("Informe um bairro.");
		}
		
		if(cliente.getCidade() == null) {
			throw new RegraNegocioException("Informe uma cidade.");
		}

		if(cliente.getUf() == null) {
			throw new RegraNegocioException("Informe uma uf.");
		}
	}

	@Override
	public Optional<Cliente> obterPorId(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public Optional<Telefone> obterTelefonesPorId(Long id) {
		return telefoneRepository.findById(id);
	}

	@Override
	public Optional<Email> obterEmailsPorId(Long id) {
		return emailRepository.findById(id);
	}

	
}
