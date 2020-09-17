package com.app.escola.aluno;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository<T, ID extends Serializable> extends JpaRepository<Aluno, String> {
	
	List<Aluno> findByDisciplinasId(int id);
	
	List<Aluno> findByNome(String nome);
}
