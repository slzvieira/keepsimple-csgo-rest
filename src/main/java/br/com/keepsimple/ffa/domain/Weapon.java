/*
 * @(#)Weapon.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Retem os detalhes de uma arma (weapon).
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
public class Weapon {

    /** Nome da arma. */
    private String name;

    /** Quantidade de mortes provocadas pela arma. */
    @JsonInclude(Include.NON_EMPTY)
    private Integer kill;

    /**
     * Construtor default.
     */
    public Weapon() {
        // do nothing
    }
    
    /**
     * Construtor qualificado com o nome da arma.
     * @param name Nome da arma.
     */
    public Weapon(String name) {
        this.name = name;
    }

    /**
     * Construtor qualificado com o nome da arma e a quantidade 
     * de mortes provocadas.
     * 
     * @param name Nome da arma.
     * @param kill Quantidade de mortes provocadas.
     */
    public Weapon(String name, Integer kill) {
        this.name = name;
        this.kill= kill;
    }
    
    /**
     * Returns the Nome da arma. 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Assigns the Nome da arma. 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the Quantidade de mortes provocadas pela arma.
     * @return the kill
     */
    public Integer getKill() {
        return kill;
    }

    /**
     * Assigns the Quantidade de mortes provocadas pela arma.
     * @param kill the kill to set
     */
    public void setKill(Integer kill) {
        this.kill = kill;
    }
}
