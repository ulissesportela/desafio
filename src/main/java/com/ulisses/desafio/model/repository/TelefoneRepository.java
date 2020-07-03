package com.ulisses.desafio.model.repository;

import com.ulisses.desafio.model.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
