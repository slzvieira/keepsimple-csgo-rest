/*
 * @(#)Player.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Retem os detalhes de um jogador (player).
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@Entity
public class Player {

    /** Nome do jogador. */
    @Id
    private String name;

    /** Codigo postal (CEP) do jogador. */
    private String cep;

    /** Endereco do player */
    @Transient
    private Address address;

    /** Quantidade de mortes provocadas pelo jogador. */
    @JsonInclude(Include.NON_EMPTY)
    private Integer kill;

    /** Quantidade de mortes sofridas pelo jogador. */
    @JsonInclude(Include.NON_EMPTY)
    private Integer die;

    /** Score do jogador (kill - die) */
    @JsonInclude(Include.NON_EMPTY)
    private Integer score;

    /**
     * Construdor default
     */
    public Player() {
        // do nothing
    }

    /**
     * Construtor qualificado com o nome do jogador.
     * @param name Nome do jogador.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Construtor qualificado com o nome, quantidade de mortes provocadas e mortes sofrida. 
     * 
     * @param name Nome do jogador.
     * @param kill Quantidade de mortes provocadas.
     * @param die Quantidade de mortes sofridas.
     */
    public Player(String name, Integer kill, Integer die) {
        this.name = name;
        this.kill = kill;
        this.die = die;
        computeScore();
    }

    /**
     * Returns the Nome do jogador.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Assigns the Nome do jogador.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o Codigo postal (CEP) do jogador.
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * Assigns the Codigo postal (CEP) do jogador.
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Obtem o Endereco do player.
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Assinala o Endereco do player.
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Returns the Quantidade de mortes provocadas pelo jogador. 
     * @return the kill
     */
    public Integer getKill() {
        return kill;
    }

    /**
     * Assigns the Quantidade de mortes provocadas pelo jogador. 
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
     * Returns the Quantidade de mortes sofridas pelo jogador.
     * @return the die
     */
    public Integer getDie() {
        return die;
    }

    /**
     * Assigns the Quantidade de mortes sofridas pelo jogador.
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
     * Returns the Score do jogador (kill - die) 
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return name;
    }
    
    /**
     * Atualiza o score do jogador.
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
