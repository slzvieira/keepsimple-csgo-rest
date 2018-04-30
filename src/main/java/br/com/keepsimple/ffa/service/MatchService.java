/*
 * @(#)MatchService.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.service;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.keepsimple.ffa.domain.Kill;
import br.com.keepsimple.ffa.domain.Match;
import br.com.keepsimple.ffa.domain.Player;
import br.com.keepsimple.ffa.domain.Weapon;
import br.com.keepsimple.ffa.repository.KillRepository;
import br.com.keepsimple.ffa.repository.MatchRepository;

/**
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private KillRepository killRepository;

    /**
     * TODO DOCUMENT ME
     * @param kill
     */
    public void saveKill(Kill kill) {
        killRepository.save(kill);
    }

    /**
     * TODO DOCUMENT ME
     * @param match
     */
    public void saveMatch(Match match) {
        matchRepository.save(match);
    }

    /**
     * TODO DOCUMENT ME
     * @return
     */
    public Collection<Match> findAllMatches() {
        return matchRepository.findAll();
        // TODO Implementar quantidade de jogadores e jogador campeao
    }

    /**
     * TODO DOCUMENT ME
     * @param id
     * @return
     */
    public Match findMatch(Integer id) {
        // TODO IMPLEMENT ME
        return null;
    }

    public List<Kill> findAllKills() {
        return killRepository.findAll();
    }

    /**
     * TODO DOCUMENT ME
     * @param matchDate
     * @return
     */
    public List<Player> findPlayersByPeriod(LocalTime startTime, LocalTime endTime) {
        List<Kill> killList = killRepository.findByPeriod(startTime, endTime);
        return toPlayerList(killList);
    }

    public List<Player> findAllPlayers() {
        List<Kill> killList = killRepository.findAll();
        return toPlayerList(killList);
    }

    public List<Weapon> findWeaponsByPeriod(LocalTime startTime, LocalTime endTime) {
        List<Kill> killList = killRepository.findByPeriod(startTime, endTime);
        return toWeaponList(killList);
    }

    public List<Weapon> findAllWeapons() {
        List<Kill> killList = killRepository.findAll();
        return toWeaponList(killList);
    }

    /**
     * Obtem o ranking de jogadores a partir da lista de kills.
     * @param killCollection
     * @return
     */
    private List<Player> toPlayerList(Collection<Kill> killCollection) {

        Map<String, Player> map = new HashMap<>();
        Player killerPlayer;
        Player killedPlayer;

        /*
         * Para cada kill, contabiliza o matador e o morto
         * em um mapa chaveado pelo nome, a fim de evitar
         * duplicidades de players
         */
        for (Kill kill : killCollection) {

            killerPlayer = map.get(kill.getKiller());
            killedPlayer = map.get(kill.getKilled());

            if (killerPlayer == null) {
                killerPlayer = new Player(kill.getKiller(), 0, 0);
                map.put(kill.getKiller(), killerPlayer);
            }

            if (killedPlayer == null) {
                killedPlayer = new Player(kill.getKilled(), 0, 0);
                map.put(kill.getKilled(), killedPlayer);
            }

            /* Soma um kill ao matador e um die ao morto */
            killerPlayer.addKill();
            killedPlayer.addDie();
        }

        /*
         * Coleta os valores do mapa (players acumulados por nome),
         * ordena pelo score e converte para lista
         */
        return map.values()
                  .stream()
                  .sorted(Comparator.comparing(Player::getScore).reversed())
                  .collect(Collectors.toList());
    }


    /**
     * Obtem o ranking das armas a partir da lista de kills.
     * @param killCollection
     * @return
     */
    private List<Weapon> toWeaponList(List<Kill> killList) {

        Map<String, Weapon> map = new HashMap<>();
        Weapon weapon;

        for (Kill kill : killList) {

            weapon = map.get(kill.getWeapon());

            if (weapon == null) {
                weapon = new Weapon(kill.getWeapon(), 0);
                map.put(kill.getWeapon(), weapon);
            }

            weapon.setKill(weapon.getKill() + 1);
        }

        /*
         * Coleta os valores do mapa (armas acumuladss por nome),
         * ordena pelo score e converte para lista
         */
        return map.values()
                  .stream()
                  .sorted(Comparator.comparing(Weapon::getKill).reversed())
                  .collect(Collectors.toList());
    }
}
