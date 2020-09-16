package com.app.escola;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class Controller {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> home() {
		return new ResponseEntity<String>("Listening...", HttpStatus.OK);
	}
}