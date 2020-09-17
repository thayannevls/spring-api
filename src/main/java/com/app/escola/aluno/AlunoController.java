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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.escola.disciplina.Disciplina;
import com.app.escola.disciplina.DisciplinaRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository<Aluno, String> alunoDAO;
	
	@Autowired
	private DisciplinaRepository<Disciplina, Integer> disciplinaDAO;
	
	@PostMapping("")
	public ResponseEntity<AlunoDTO> create(@RequestBody Aluno aluno) {
		return new ResponseEntity<AlunoDTO>(AlunoDTO.objToDTO(alunoDAO.save(aluno)), HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<AlunoDTO>> getAll() {
		List<Aluno> alunos = this.alunoDAO.findAll();
		List<AlunoDTO> response = alunos.stream()
									.map(a -> AlunoDTO.objToDTO(a))
									.collect(Collectors.toList());
		return new ResponseEntity<List<AlunoDTO>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/{alunoId}/disciplinas")
	public ResponseEntity<?> addDisciplina(@PathVariable String alunoId, @RequestBody Disciplina disciplina) {
		Optional<Aluno> alunoOpt = alunoDAO.findById(alunoId);
		
		if(!alunoOpt.isPresent()) {
			return new ResponseEntity<String>("Aluno não encontrado", HttpStatus.NOT_FOUND);
		}
		
		Optional<Disciplina> disciplinaOpt = disciplinaDAO.findById(disciplina.getId());
		
		if(!disciplinaOpt.isPresent()) {
			return new ResponseEntity<String>("Disciplina não encontrada", HttpStatus.NOT_FOUND);
		}
		
		Aluno aluno = alunoOpt.get();
		
		aluno.addDisciplina(disciplinaOpt.get());
		
		alunoDAO.save(aluno);
		
		return new ResponseEntity<AlunoDTO>(AlunoDTO.objToDTO(alunoDAO.save(aluno)), HttpStatus.OK);
		
	}
	
	@GetMapping("/disciplinas/{disciplinaId}")
	public ResponseEntity<?> getByDisciplina(@PathVariable int disciplinaId) {
		return new ResponseEntity<List<Aluno>>(alunoDAO.findByDisciplinasId(disciplinaId), HttpStatus.OK);
	}
}
