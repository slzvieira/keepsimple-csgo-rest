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
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
public interface KillRepository extends JpaRepository<Kill, Integer> {

    @Query("SELECT k FROM Kill k WHERE k.killtime >= :startTime AND k.killtime <= :endTime")
    List<Kill> findByPeriod(@Param("startTime") LocalTime startTime, @Param("endTime") LocalTime endTime);
}
