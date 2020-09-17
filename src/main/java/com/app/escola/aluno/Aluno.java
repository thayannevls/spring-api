package com.app.escola.aluno;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.app.escola.disciplina.Disciplina;

@Entity
public class Aluno {
	@Id
	private String matricula;
	private String nome;
	private int serie;
	private String senha;
	
	@OneToMany
	private List<Disciplina> disciplinas;
	
	public Aluno() {
		super();
	}

	public Aluno(String matricula, String nome, int serie, String senha, List<Disciplina> disciplina) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.serie = serie;
		this.senha = senha;
		this.disciplinas = disciplina;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplina) {
		this.disciplinas = disciplina;
	}
	
	public List<Disciplina> addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
		
		return this.disciplinas;
	}
	
	
	
}
