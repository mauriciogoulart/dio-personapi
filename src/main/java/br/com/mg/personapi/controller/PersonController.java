package br.com.mg.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mg.personapi.dto.PersonDTO;
import br.com.mg.personapi.service.PersonService;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonDTO>> get() {
		List<PersonDTO> people = service.findAll();
		return ResponseEntity.ok(people);	
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> create(@RequestBody @Valid PersonDTO personDTO) {
		PersonDTO savedPerson = service.save(personDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
	}

}
