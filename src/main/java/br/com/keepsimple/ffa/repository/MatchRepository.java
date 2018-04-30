/*
 * @(#)MatchRepository.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.keepsimple.ffa.domain.Match;

/**
 * Repositorio de partidas.s
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

}
