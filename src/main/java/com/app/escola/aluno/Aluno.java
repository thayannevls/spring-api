package com.app.escola.aluno;

import java.util.ArrayList;
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
	private int grau;
	private String senha;
	
	@OneToMany
	private List<Disciplina> disciplinas;

	public Aluno(String matricula, String nome, int grau, String senha) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.grau = grau;
		this.senha = senha;
		this.disciplinas = new ArrayList<Disciplina>();
	}
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public int getGrau() {
		return grau;
	}
	
	public void setGrau(int grau) {
		this.grau = grau;
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
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Disciplina> addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
		return this.disciplinas;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", grau=" + grau + ", senha=" + senha + "]";
	}
	
}
