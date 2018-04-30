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
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Retem os detalhes de uma partida.
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@Entity
public class Match {

    /** ID da partida. */
    @Id
    private Integer match;

    /** Data/hora de inicio. */
    private ZonedDateTime begin;

    /** Data/hora de fim. */
    private ZonedDateTime end;

    /** List de jogadores participantes. */
    @Transient
    @JsonInclude(Include.NON_EMPTY)
    private List<Player> players;

    /** Quantidade de jogadores */
    @Transient
    @JsonInclude(Include.NON_EMPTY)
    private Integer numberPlayers;

    /** Nome do campeao da partida. */
    @Transient
    @JsonInclude(Include.NON_EMPTY)
    private String championName;

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

	/**
	 * Returns the Quantidade de jogadores.
	 * @return the numberPlayers
	 */
	public Integer getNumberPlayers() {
		return numberPlayers;
	}

	/**
	 * Assigns the Quantidade de jogadores.
	 * @param numberPlayers the numberPlayers to set
	 */
	public void setNumberPlayers(Integer numberPlayers) {
		this.numberPlayers = numberPlayers;
	}

	/**
	 * Return the Nome do campeao da partida.
	 * @return the championName
	 */
	public String getChampionName() {
		return championName;
	}

	/**
	 * Assigns the Nome do campeao da partida.
	 * @param championName the championName to set
	 */
	public void setChampionName(String championName) {
		this.championName = championName;
	}
}
