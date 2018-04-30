/*
 * @(#)Kill.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.domain;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Retem os dados de uma morte a ser registada no sistema.
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@Entity
public class Kill {

    /** ID da morte. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** ID da partida. */
    private Integer match;

    /** Momento da morte. */
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime killtime;

    /** Jogador que matou. */
    private String killer;

    /** Jogador que morreu. */
    private String killed;

    /** Arma utilizada. */
    private String weapon;

    /**
     * Returns the ID da morte.
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Assigns the ID da morte.
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * Returns the Momento da morte.
     * @return the killtime
     */
    public LocalTime getKilltime() {
        return killtime;
    }

    /**
     * Assigns the Momento da morte.
     * @param killtime the killtime to set
     */
    public void setKilltime(LocalTime killtime) {
        this.killtime = killtime;
    }

    /**
     * Returns the Jogador que matou. 
     * @return the killer
     */
    public String getKiller() {
        return killer;
    }

    /**
     * Assigns the Jogador que matou. 
     * @param killer the killer to set
     */
    public void setKiller(String killer) {
        this.killer = killer;
    }

    /**
     * Returns the Jogador que morreu. 
     * @return the killed
     */
    public String getKilled() {
        return killed;
    }

    /**
     * Assigns the Jogador que morreu. 
     * @param killed the killed to set
     */
    public void setKilled(String killed) {
        this.killed = killed;
    }

    /**
     * Returns the Arma utilizada. 
     * @return the weapon
     */
    public String getWeapon() {
        return weapon;
    }

    /**
     * Assigns the Arma utilizada. 
     * @param weapon the weapon to set
     */
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
