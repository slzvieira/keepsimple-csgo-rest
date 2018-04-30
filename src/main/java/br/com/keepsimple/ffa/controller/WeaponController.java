/*
 * @(#)WeaponController.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.keepsimple.ffa.domain.Weapon;
import br.com.keepsimple.ffa.service.MatchService;

/**
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@RestController
public class WeaponController {

    @Autowired
    private MatchService service;

    @RequestMapping(method = RequestMethod.GET, value = "/weapons/{startTime}/{endTime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Weapon>> getWeapons(
            @PathVariable @DateTimeFormat(pattern = "HH:mm:ss") LocalTime startTime,
            @PathVariable @DateTimeFormat(pattern = "HH:mm:ss") LocalTime endTime) {

        List<Weapon> weaponList = service.findWeaponsByPeriod(startTime, endTime);
        return new ResponseEntity<>(weaponList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/weapons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Weapon>> getAllWeapons() {
        List<Weapon> weaponList = service.findAllWeapons();
        return new ResponseEntity<>(weaponList, HttpStatus.OK);
    }
}
