/*
 * @(#)MatchService.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.keepsimple.ffa.dto.Kill;
import br.com.keepsimple.ffa.dto.Match;
import br.com.keepsimple.ffa.dto.Player;

/**
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@Service
public class MatchService {

    /**
     * TODO DOCUMENT ME
     * @return
     */
    public Collection<Match> findAllMatches() {
        
        Collection<Match> collection = new ArrayList<>();
        Match match;

        match = new Match();
        match.setMatch(12345);
        match.setBegin(ZonedDateTime.of(2018, 2, 23, 23, 12, 8, 0, ZoneId.systemDefault()));
        match.setEnd(ZonedDateTime.of(2018, 2, 23, 23, 45, 15, 0, ZoneId.systemDefault()));
        match.setPlayers(new ArrayList<>());
        match.getPlayers().add(new Player("Manuel", 8, 3));
        match.getPlayers().add(new Player("Joaquim", 3, null));
        match.getPlayers().add(new Player("Maria", null, 8));
        collection.add(match);

        match = new Match();
        match.setMatch(53674);
        match.setBegin(ZonedDateTime.of(2018, 2, 23, 23, 12, 8, 0, ZoneId.systemDefault()));
        match.setEnd(ZonedDateTime.of(2018, 2, 23, 23, 45, 15, 0, ZoneId.systemDefault()));
        match.setPlayers(new ArrayList<>());
        match.getPlayers().add(new Player("Manuel"));
        match.getPlayers().add(new Player("Joaquim"));
        match.getPlayers().add(new Player("Maria"));
        match.getPlayers().add(new Player("Ricardo"));
        match.getPlayers().add(new Player("Augusto"));
        collection.add(match);

        match = new Match();
        match.setMatch(97721);
        match.setBegin(ZonedDateTime.of(2018, 3, 2, 1, 22, 40, 0, ZoneId.systemDefault()));
        match.setEnd(ZonedDateTime.of(2018, 3, 2, 2, 45, 2, 0, ZoneId.systemDefault()));
        match.setPlayers(new ArrayList<>());
        match.getPlayers().add(new Player("Joaquim"));
        match.getPlayers().add(new Player("Maria"));
        collection.add(match);
        
        return collection;
    }

    /**
     * TODO DOCUMENT ME
     * @param id
     * @return
     */
    public Match findByPk(Integer id) {

        Match match = new Match();
        match.setMatch(id);
        match.setBegin(ZonedDateTime.of(2018, 2, 23, 23, 12, 8, 0, ZoneId.systemDefault()));
        match.setEnd(ZonedDateTime.of(2018, 2, 23, 23, 45, 15, 0, ZoneId.systemDefault()));
        match.setPlayers(new ArrayList<>());
        match.getPlayers().add(new Player("Manuel", 8, 3));
        match.getPlayers().add(new Player("Joaquim", 3, null));
        match.getPlayers().add(new Player("Maria", null, 8));
        
        return match;
    }

    public void saveKill(Kill kill) {
        System.out.println("##############################");
        System.out.println("###### Registrando Kill ######");
        System.out.println("##############################");
        System.out.println(kill.getMatch() + " - " + kill.getKilltime() + " - " + kill.getKiller() + " - " + kill.getKilled() + " - " + kill.getWeapon());
    }
}
