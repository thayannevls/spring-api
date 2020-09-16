package com.app.escola.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository<T, ID>  extends JpaRepository<Aluno, String> {
}
