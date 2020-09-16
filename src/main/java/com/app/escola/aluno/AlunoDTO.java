package com.app.escola.aluno;

import java.util.List;

import com.app.escola.disciplina.Disciplina;

public class AlunoDTO {
	private Aluno aluno;
	
	public AlunoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private AlunoDTO(Aluno aluno) {
		super();
		this.aluno = aluno;
	}
	
	public static AlunoDTO objToDTO(Aluno aluno) {
		return new AlunoDTO(aluno);
	}

	public String getMatricula() {
		return this.aluno.getMatricula();
	}

	public String getNome() {
		return this.aluno.getNome();
	}


	public int getGrau() {
		return this.aluno.getGrau();
	}
	
	public List<Disciplina> getDisciplinas() {
		return this.aluno.getDisciplinas();
	}

	
}
