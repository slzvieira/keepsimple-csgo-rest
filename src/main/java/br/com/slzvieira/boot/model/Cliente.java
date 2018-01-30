package br.com.slzvieira.boot.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Cliente {

    private Integer id;
	private String nome;
	
	public Integer getId() {
	    return id;
	}
	
	public void setId(Integer id) {
	    this.id = id;
	}
	
	public String getNome() {
	    return nome;
	}
	
	public void setNome(String nome) {
	    this.nome = nome;
	}
}
