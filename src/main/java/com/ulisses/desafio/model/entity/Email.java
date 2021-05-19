package com.ulisses.desafio.model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Email", catalog="postgres", schema="desafio")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

}
