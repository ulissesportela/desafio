package com.ulisses.desafio.model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Telefone", catalog="postgres", schema="desafio")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

}
