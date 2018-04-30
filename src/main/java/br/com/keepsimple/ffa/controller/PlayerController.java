/*
 * @(#)PlayerController.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.keepsimple.ffa.domain.Player;
import br.com.keepsimple.ffa.service.MatchService;

/**
 * Expoe o microservico REST para a entidade {@link Player}
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@RestController
public class PlayerController {

    /** Log da aplicacao (Commons logging). */
    private static final Log log = LogFactory.getLog(PlayerController.class);

    /** Servico responsavel por obter os dados a serem expostos. */
    @Autowired
    private MatchService service;

    /**
     * Prove o ranking parcial (contabilidade apenas no periodo especificado)
     * dos jogadores ordenando por pontuacao (kill - die) de forma decrescente.
     * 
     * @param startTime Hora de inicio do periodo desejado.
     * @param endTime Hora de termino do periodo desejado.
     * @return Lista de jogadores ordenados por pontuacao.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/players/{startTime}/{endTime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getPlayers(
            @PathVariable @DateTimeFormat(pattern = "HH:mm:ss") LocalTime startTime,
            @PathVariable @DateTimeFormat(pattern = "HH:mm:ss") LocalTime endTime) {

        if (log.isDebugEnabled()) {
            log.debug("PlayerController#getPlayers(" + startTime.format(DateTimeFormatter.ISO_LOCAL_TIME) + ", "
                    + endTime.format(DateTimeFormatter.ISO_LOCAL_TIME) + ") - Inicio");
        }

        List<Player> playerList = service.findPlayersByPeriod(startTime, endTime);

        log.debug("PlayerController#getPlayers() - Fim");
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

    /**
     * Prove o ranking completo (de todos os kills registrados pelo sistema)
     * dos jogadores ordenando por pontuacao (kill - die) de forma decrescente.
     * 
     * @return Lista de jogadores ordenados por pontuacao.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/players", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getAllPlayers() {
        log.debug("PlayerController#getAllPlayers() - Inicio");
        List<Player> playerList = service.findAllPlayers();
        log.debug("PlayerController#getAllPlayers() - Fim");
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }
}
