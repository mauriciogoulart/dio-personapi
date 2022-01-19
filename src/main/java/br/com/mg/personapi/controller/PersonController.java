package br.com.mg.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mg.personapi.entity.Person;
import br.com.mg.personapi.service.PersonService;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> create(@RequestBody Person person) {
		Person savedPerson = service.save(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
	}

	@GetMapping
	public String test() {
		return "hello everyone";
	}

}
