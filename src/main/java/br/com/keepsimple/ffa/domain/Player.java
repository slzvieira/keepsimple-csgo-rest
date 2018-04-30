/*
 * @(#)Player.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * Adds a kill to the score
     */
    public void addKill() {
        if (kill == null) {
            kill = 1;
        } else {
            kill++;
        }
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
     * Adds a die to the score
     */
    public void addDie() {
        if (die == null) {
            die = 1;
        } else {
            die++;
        }
        computeScore();
    }

    /**
     * Returns the XXX
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    public String toString() {
        return name;
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
