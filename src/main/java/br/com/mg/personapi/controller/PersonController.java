package br.com.mg.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mg.personapi.dto.PersonDTO;
import br.com.mg.personapi.exception.PersonNotFoundException;
import br.com.mg.personapi.service.PersonService;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> create(@RequestBody @Valid PersonDTO personDTO) {
		PersonDTO savedPerson = service.create(personDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/{identificationDocument}")
	public void delete(@PathVariable("identificationDocument") String identificationDocument)
			throws PersonNotFoundException {
		service.delete(identificationDocument);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonDTO>> findAll() {
		List<PersonDTO> people = service.findAll();
		return ResponseEntity.ok(people);
	}

	@GetMapping(path = "/{identificationDocument}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> findById(@PathVariable("identificationDocument") String identificationDocument)
			throws PersonNotFoundException {
		PersonDTO person = service.findById(identificationDocument);
		return ResponseEntity.ok(person);
	}

	@PutMapping(path = "/{identificationDocument}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> update(@PathVariable("identificationDocument") String identificationDocument,
			@RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
		PersonDTO person = service.update(identificationDocument, personDTO);
		return ResponseEntity.ok(person);
	}

}
