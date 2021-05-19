package com.ulisses.desafio.model.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Cliente", catalog="postgres", schema="desafio")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name="nome")
		private String nome;
		
		@Column(name="cpf")
		private String cpf;

		@Column(name="cep")
		private String cep;
		
		@Column(name="logradouro")
		private String logradouro;

		@Column(name="bairro")
		private String bairro;

		@Column(name="complemento")
		private String complemento;
		
		@Column(name="cidade")
		private String cidade;

		@Column(name="uf")
		private String uf;

		//@OneToMany(mappedBy = "telefone", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
		//private List<Telefone> telefone;
		
		//@OneToMany(mappedBy = "email", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
		//private List<Email> email;
}
