package com.app.escola.aluno;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.escola.disciplina.Disciplina;
import com.app.escola.disciplina.DisciplinaRepository;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoRepository<Aluno, String> alunoDAO;
	
	@Autowired 
	private DisciplinaRepository<Disciplina, Integer> disciplinaDAO;
	
	@GetMapping("/aluno")
	public ResponseEntity<List<AlunoDTO>> get() {
		List<Aluno> alunos = this.alunoDAO.findAll();
		List<AlunoDTO> response = alunos.stream()
									.map(a -> AlunoDTO.objToDTO(a))
									.collect(Collectors.toList());
		return new ResponseEntity<List<AlunoDTO>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/aluno")
	public ResponseEntity<AlunoDTO> create(@RequestBody Aluno aluno) {
		return new ResponseEntity<AlunoDTO>(AlunoDTO.objToDTO(this.alunoDAO.save(aluno)), HttpStatus.CREATED);
	}
	
	@PostMapping("/aluno/{alunoId}")
	public ResponseEntity<?> addDisciplina(@PathVariable String alunoId, @RequestBody Disciplina disciplina) {
		Optional<Aluno> optAluno = alunoDAO.findById(alunoId);
		if(!optAluno.isPresent()) {
			return new ResponseEntity<String>("Aluno não encontrado", HttpStatus.NOT_FOUND);

		}
		if(!disciplinaDAO.existsById(disciplina.getId())) {
			return new ResponseEntity<String>("Disciplina não encontrada", HttpStatus.NOT_FOUND);
		}
		
		Aluno aluno = optAluno.get();
		aluno.addDisciplina(disciplinaDAO.findById(disciplina.getId()).get());
		alunoDAO.save(aluno);
		
		return new ResponseEntity<AlunoDTO>(AlunoDTO.objToDTO(aluno), HttpStatus.OK);
	}
}
