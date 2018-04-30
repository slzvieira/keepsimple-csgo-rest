/*
 * @(#)MatchController.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.keepsimple.ffa.domain.Match;
import br.com.keepsimple.ffa.service.MatchService;

/**
 * Expoe o microservico REST para a entidade {@link Match}
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@RestController
public class MatchController {

    /** Servico responsavel por obter os dados a serem expostos. */
    @Autowired
    private MatchService service;

    /**
     * Prove os edetalhes de uma partida (match).
     * @param id Id da partida desejada
     * @return Detalhes da partida.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/matches/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Match> getMatch(@PathVariable Integer id) {
        Match match = service.findMatch(id);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    /**
     * Prove a lista completa de todas as partidas registradas no sistema.
     * @return Lista de todas as partidas
     */
    @RequestMapping(method = RequestMethod.GET, value = "/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Match>> getAllMatches() {
        Collection<Match> matchCollection = service.findAllMatches();
        return new ResponseEntity<>(matchCollection, HttpStatus.OK);
    }
}
