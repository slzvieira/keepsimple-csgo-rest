/*
 * @(#)Weapon.java 1.00 29/abr/2018
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
public class Weapon {

    private String name;

    @JsonInclude(Include.NON_EMPTY)
    private Integer kill;

    /**
     * TODO DOCUMENT ME
     */
    public Weapon() {
        // do nothing
    }
    
    /**
     * TODO DOCUMENT ME
     * @param name
     */
    public Weapon(String name) {
        this.name = name;
    }

    /**
     * TODO DOCUMENT ME
     * 
     * @param name
     * @param kill
     */
    public Weapon(String name, Integer kill) {
        this.name = name;
        this.kill= kill;
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
    }
}
