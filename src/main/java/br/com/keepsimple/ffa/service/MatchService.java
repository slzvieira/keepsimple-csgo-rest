/*
 * @(#)MatchService.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.keepsimple.ffa.domain.Kill;
import br.com.keepsimple.ffa.domain.Match;
import br.com.keepsimple.ffa.domain.Player;
import br.com.keepsimple.ffa.domain.Weapon;
import br.com.keepsimple.ffa.repository.MatchRepository;

/**
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@Service
public class MatchService {

//    @Autowired
//    private MatchRepository repository;
    
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
    public Match findMatch(Integer id) {

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

    /**
     * TODO DOCUMENT ME
     * @param kill
     */
    public void saveKill(Kill kill) {
        System.out.println("##############################");
        System.out.println("###### Registrando Kill ######");
        System.out.println("##############################");
        System.out.println(kill.getMatch() + " - " + kill.getKilltime() + " - " + kill.getKiller() + " - " + kill.getKilled() + " - " + kill.getWeapon());
    }

    /**
     * TODO DOCUMENT ME
     * @param matchDate
     * @return
     */
    public List<Player> findPlayersByMatchDate(LocalDate matchDate) {
        System.out.println("#################################");
        System.out.println("### Buscando players por data ###");
        System.out.println(matchDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println("#################################");
        return findAllPlayers().stream().filter(p -> p.getKill() < 10).collect(Collectors.toList());
    }

    public List<Player> findAllPlayers() {

        List<Player> list = new ArrayList<>();

        list.add(new Player("Manuel", 18, 15));
        list.add(new Player("Joaquim", 5, 23));
        list.add(new Player("Maria", 4, 25));
        list.add(new Player("Adolfo", 4, 19));
        
        return list;
    }

    public List<Weapon> findWeaponsByPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        System.out.println("#################################");
        System.out.println("### Buscando weapons por data ###");
        System.out.println(startDate.format(DateTimeFormatter.ISO_DATE_TIME) + " | " + endDate.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("#################################");
        return findAllWeapons().stream().filter(p -> p.getKill() < 40).collect(Collectors.toList());
    }

    public List<Weapon> findAllWeapons() {
        
        List<Weapon> list = new ArrayList<>();
        
        list.add(new Weapon("Tres Oitao", 35));
        list.add(new Weapon("Rifle Cano Longo", 19));
        list.add(new Weapon("Sniper", 23));
        list.add(new Weapon("9 mm", 40));
        list.add(new Weapon("Canivete de abrir garrafa", 0));
        list.add(new Weapon("Canhao do exercito", 252));
        list.add(new Weapon("Bomba nuclear", 152463));
        
        return list;
    }
}
