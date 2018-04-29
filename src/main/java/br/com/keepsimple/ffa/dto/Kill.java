/*
 * @(#)Kill.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.dto;

import java.time.LocalTime;

/**
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
public class Kill {

    /** ID da partida. */
    private Integer match;

    /** Momento da morte. */
    private LocalTime killtime;

    /** Jogador que matou. */
    private String killer;

    /** Jogador que morreu. */
    private String killed;

    /** Arma utilizada. */
    private String weapon;

    /**
     * Returns the XXX
     * @return the match
     */
    public Integer getMatch() {
        return match;
    }

    /**
     * Assigns the XXX
     * @param match the match to set
     */
    public void setMatch(Integer match) {
        this.match = match;
    }

    /**
     * Returns the XXX
     * @return the killtime
     */
    public LocalTime getKilltime() {
        return killtime;
    }

    /**
     * Assigns the XXX
     * @param killtime the killtime to set
     */
    public void setKilltime(LocalTime killtime) {
        this.killtime = killtime;
    }

    /**
     * Returns the XXX
     * @return the killer
     */
    public String getKiller() {
        return killer;
    }

    /**
     * Assigns the XXX
     * @param killer the killer to set
     */
    public void setKiller(String killer) {
        this.killer = killer;
    }

    /**
     * Returns the XXX
     * @return the killed
     */
    public String getKilled() {
        return killed;
    }

    /**
     * Assigns the XXX
     * @param killed the killed to set
     */
    public void setKilled(String killed) {
        this.killed = killed;
    }

    /**
     * Returns the XXX
     * @return the weapon
     */
    public String getWeapon() {
        return weapon;
    }

    /**
     * Assigns the XXX
     * @param weapon the weapon to set
     */
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
