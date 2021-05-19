package com.ulisses.desafio.model.repository;

import com.ulisses.desafio.api.dto.EmailDTO;
import com.ulisses.desafio.api.dto.TelefoneDTO;
import com.ulisses.desafio.model.entity.Email;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

	@Transactional
	@Modifying
	@Query("DELETE FROM Email e"
			+ " WHERE e.cliente.id = :clienteId")
	void apagarVinculo(Long clienteId);
	
	@Query("SELECT NEW com.ulisses.desafio.api.dto.EmailDTO(e.id, e.email) FROM Email e"
			+ " WHERE e.cliente.id = :clienteId")
	List<EmailDTO> lista(Long clienteId);
}
