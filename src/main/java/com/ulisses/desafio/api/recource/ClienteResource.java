package com.ulisses.desafio.api.recource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ulisses.desafio.api.dto.ClienteDTO;
import com.ulisses.desafio.exception.RegraNegocioException;
import com.ulisses.desafio.model.entity.Cliente;
import com.ulisses.desafio.model.entity.Telefone;
import com.ulisses.desafio.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteResource {

	private final ClienteService service;
	
	@GetMapping
	public ResponseEntity buscar(
			@RequestParam(value="nome", required = false) String nome,
			@RequestParam(value="cpf", required = false) String cpf,
			@RequestParam(value="email", required = false) String email
			) {
		Cliente clienteFiltro = new Cliente();
		clienteFiltro.setNome(nome);
		clienteFiltro.setCpf(cpf);
		clienteFiltro.setEmail(email);
		
		List<Cliente> clientes =  service.buscar(clienteFiltro);
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("{id}")
	public ResponseEntity obterCliente( @PathVariable("id") Long id ) {
		return service.obterPorId(id)
				.map( cliente -> new ResponseEntity(converter(cliente), HttpStatus.OK) )
				.orElseGet( () -> new ResponseEntity(HttpStatus.NOT_FOUND) );
}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody ClienteDTO dto) {
		
		Cliente cliente = converter(dto);

		try {
			Cliente clienteSalvo = service.salvar(cliente);
			return new ResponseEntity(clienteSalvo, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody ClienteDTO dto) {
		return service.obterPorId(id).map(entity -> {
			try {
				Cliente cliente = converter(dto);
				cliente.setId(entity.getId());
				service.atualizar(cliente);
				return ResponseEntity.ok(cliente);
			} catch (RegraNegocioException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}

		}).orElseGet( () -> new ResponseEntity("Cliente não encontrado.", HttpStatus.BAD_REQUEST));
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar( @PathVariable("id") Long id) {
		return service.obterPorId(id).map( entity -> {
			service.deletar(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet( () -> new ResponseEntity("Cliente não encontrado.", HttpStatus.BAD_REQUEST));
	}
	
	private Cliente converter(ClienteDTO dto) {
		
		//List<Telefone> telefones = new ArrayList<>();
		
		
		Cliente cliente = Cliente.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.cpf(dto.getCpf())
				.telefones(dto.getTelefones())
				.email(dto.getEmail())
				.cep(dto.getCep())
				.logradouro(dto.getLogradouro())
				.bairro(dto.getBairro())
				.complemento(dto.getComplemento())
				.cidade(dto.getCidade())
				.uf(dto.getUf()).build();
		return cliente;
	}

	private ClienteDTO converter(Cliente cliente) {
		return ClienteDTO.builder()
				.id(cliente.getId())
				.nome(cliente.getNome())
				.cpf(cliente.getCpf())
				.telefones(cliente.getTelefones())
				.email(cliente.getEmail())
				.cep(cliente.getCep())
				.logradouro(cliente.getLogradouro())
				.bairro(cliente.getBairro())
				.complemento(cliente.getComplemento())
				.cidade(cliente.getCidade())
				.uf(cliente.getUf()).build();
					
	}
}
