package com.ulisses.desafio.api.dto;

import java.util.List;

import com.ulisses.desafio.model.entity.Telefone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

	private Long id;
	private String nome;
	private String cpf;
	private List<Telefone> telefones;
	private String email;
	private String cep;
	private String logradouro;
	private String bairro;
	private String complemento;
	private String cidade;
	private String uf;
}
