package br.com.felipe.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.desafio.models.Round;

public interface RoundRepository extends JpaRepository<Round, Long>{
    
}
