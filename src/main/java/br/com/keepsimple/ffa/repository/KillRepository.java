/*
 * @(#)KillRepository.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.keepsimple.ffa.domain.Kill;

/**
 * Repositorio de kills.
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
public interface KillRepository extends JpaRepository<Kill, Integer> {

    /**
     * Obtem a lista de kill computadas em um periodo especificado.
     * 
     * TODO O metodo esta apresentado algum problema onde nao houve
     * tempo habil para corrigir. As clausulas >= e <= nao estao
     * funcionando corretamente. Desculpe! :-(
     * 
     * @param startTime Hora de inicio
     * @param endTime Hora de fim
     * @return Lista de kills registrados dentro do periodo.
     */
    @Query("SELECT k FROM Kill k WHERE k.killtime >= :startTime AND k.killtime <= :endTime")
    List<Kill> findByPeriod(@Param("startTime") LocalTime startTime, @Param("endTime") LocalTime endTime);

	/**
	 * Obtem a lista de kills por partida
	 * @param id ID da partida
	 * @return Lista de kills
	 */
	List<Kill> findByMatch(Integer id);
}
