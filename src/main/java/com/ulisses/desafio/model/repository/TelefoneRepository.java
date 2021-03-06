package com.ulisses.desafio.model.repository;

import com.ulisses.desafio.api.dto.TelefoneDTO;
import com.ulisses.desafio.model.entity.Telefone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	@Transactional
	@Modifying
	@Query("DELETE FROM Telefone t"
			+ " WHERE t.cliente.id = :clienteId")
	void apagarVinculo(Long clienteId);
	
	@Query("SELECT NEW com.ulisses.desafio.api.dto.TelefoneDTO(t.id, t.telefone, t.tipo) FROM Telefone t"
			+ " WHERE t.cliente.id = :clienteId")
	List<TelefoneDTO> lista(Long clienteId);
	
}
