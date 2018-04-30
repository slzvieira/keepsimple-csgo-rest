/*
 * @(#)Match.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.domain;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Retem os detalhes de uma partida.
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@Entity
public class Match {

    /** ID da partida. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer match;

    /** Data/hora de inicio. */
    private ZonedDateTime begin;

    /** Data/hora de fim. */
    private ZonedDateTime end;

    /** List de jogadores participantes. */
    @Transient
    private List<Player> players;

    /**
     * Returns the ID da partida.
     * @return the match
     */
    public Integer getMatch() {
        return match;
    }

    /**
     * Assigns the ID da partida.
     * @param match the match to set
     */
    public void setMatch(Integer match) {
        this.match = match;
    }

    /**
     * Returns the Data/hora de inicio.
     * @return the begin
     */
    public ZonedDateTime getBegin() {
        return begin;
    }

    /**
     * Assigns the Data/hora de inicio.
     * @param begin the begin to set
     */
    public void setBegin(ZonedDateTime begin) {
        this.begin = begin;
    }

    /**
     * Returns the Data/hora de fim. 
     * @return the end
     */
    public ZonedDateTime getEnd() {
        return end;
    }

    /**
     * Assigns the Data/hora de fim.
     * @param end the end to set
     */
    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }

    /**
     * Returns the List de jogadores participantes.
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Assigns the List de jogadores participantes.
     * @param players the players to set
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
