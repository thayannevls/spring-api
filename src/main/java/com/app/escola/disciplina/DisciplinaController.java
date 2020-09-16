package com.app.escola.disciplina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository<Disciplina, Integer> disciplinaDAO;
	
	@RequestMapping(value = "/disciplina", method = RequestMethod.GET)
	public ResponseEntity<?> get() {
		return new ResponseEntity<List<Disciplina>>(this.disciplinaDAO.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/disciplina")
	public ResponseEntity<Disciplina> create(@RequestBody Disciplina disciplina) {
		return new ResponseEntity<Disciplina>(this.disciplinaDAO.save(disciplina), HttpStatus.CREATED);
	}
}
