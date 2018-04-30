/*
 * @(#)KillController.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.keepsimple.ffa.domain.Kill;
import br.com.keepsimple.ffa.service.MatchService;

/**
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@RestController
public class KillController {

    @Autowired
    private MatchService service;

    @RequestMapping(method = RequestMethod.GET, value = "/kills", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Kill>> getAllKills() {
        List<Kill> killList = service.findAllKills();
        return new ResponseEntity<>(killList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/kills", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Kill> postKill(@RequestBody Kill kill) {
        service.saveKill(kill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
