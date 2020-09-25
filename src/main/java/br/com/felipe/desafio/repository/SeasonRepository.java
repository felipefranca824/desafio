package br.com.felipe.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.desafio.models.Season;

/**
 * SeasonRepository
 */
public interface SeasonRepository extends JpaRepository<Season, Long> {

    
}