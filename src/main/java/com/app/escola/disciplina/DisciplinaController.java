package com.app.escola.disciplina;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository<Disciplina, Integer> disciplinaDAO;
	
	
	@RequestMapping(value = "/disciplina", method = RequestMethod.POST)
	public ResponseEntity<Disciplina> create(@RequestBody Disciplina disciplina) {
		return new ResponseEntity<Disciplina>(disciplinaDAO.save(disciplina), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/disciplina", method = RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> getAll() {
		return new ResponseEntity<List<Disciplina>>(disciplinaDAO.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/disciplina/{disciplinaId}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable int disciplinaId) {
		Optional<Disciplina> opt = disciplinaDAO.findById(disciplinaId);
		
		if(!opt.isPresent()) {
			return new ResponseEntity<String>("Disciplina não encontrada", HttpStatus.NOT_FOUND);
		}
		
		Disciplina disciplina = opt.get();
		return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
	}
	
}
