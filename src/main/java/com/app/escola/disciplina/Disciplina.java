package com.app.escola.disciplina;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplina {
	
	@Id @GeneratedValue
	private int id;
	private String nome;
	
	public Disciplina () {}
	
	public Disciplina(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Disciplina(String nome) {
		super();
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + "]";
	}
}
