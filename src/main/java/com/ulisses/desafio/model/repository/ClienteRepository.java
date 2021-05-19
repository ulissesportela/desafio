package com.ulisses.desafio.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulisses.desafio.model.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	//Optional<Cliente> fingByCpf(String cpf);

	boolean existsByCpf(String cpf);
	
}
