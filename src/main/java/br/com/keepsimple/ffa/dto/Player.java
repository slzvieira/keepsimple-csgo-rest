/*
 * @(#)Player.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
public class Player {

    private String name;

    @JsonInclude(Include.NON_EMPTY)
    private Integer kill;

    @JsonInclude(Include.NON_EMPTY)
    private Integer die;

    @JsonInclude(Include.NON_EMPTY)
    private Integer score;

    /**
     * Default constructor
     */
    public Player() {
        // do nothing
    }

    /**
     * Constructor qualified with the player name.
     * @param name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Constructor qualified with the player name, quantity of kills and quantity of killeds
     * 
     * @param name
     * @param kill
     * @param die
     */
    public Player(String name, Integer kill, Integer die) {
        this.name = name;
        this.kill = kill;
        this.die = die;
        computeScore();
    }

    /**
     * Returns the XXX
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Assigns the XXX
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the XXX
     * @return the kill
     */
    public Integer getKill() {
        return kill;
    }

    /**
     * Assigns the XXX
     * @param kill the kill to set
     */
    public void setKill(Integer kill) {
        this.kill = kill;
        computeScore();
    }

    /**
     * Returns the XXX
     * @return the die
     */
    public Integer getDie() {
        return die;
    }

    /**
     * Assigns the XXX
     * @param die the die to set
     */
    public void setDie(Integer die) {
        this.die = die;
        computeScore();
    }

    /**
     * Returns the XXX
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * TODO DOCUMENT ME
     */
    private void computeScore() {
        if (kill != null && die != null) {
            score = kill - die;
        } else if (kill != null) {
            score = kill;
        } else if (die != null) {
            score = -die;
        } else {
            score = null;
        }
    }
}
