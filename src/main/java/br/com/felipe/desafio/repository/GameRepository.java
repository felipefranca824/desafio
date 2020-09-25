package br.com.felipe.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.desafio.models.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
