package br.com.mg.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mg.personapi.dto.PersonDTO;
import br.com.mg.personapi.entity.Person;
import br.com.mg.personapi.exception.PersonNotFoundException;
import br.com.mg.personapi.mapper.PersonMapper;
import br.com.mg.personapi.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	public PersonDTO create(PersonDTO personDTO) {
		Person person = personMapper.toModel(personDTO);
		repository.save(person);
		return personMapper.toDTO(person);
	}

	public void delete(String identificationDocument) throws PersonNotFoundException {
		Person person = findPersonById(identificationDocument);
		repository.delete(person);
	}

	public List<PersonDTO> findAll() {
		List<Person> people = repository.findAll();
		List<PersonDTO> peopleDTO = people.stream().map(personMapper::toDTO).collect(Collectors.toList());
		return peopleDTO;
	}

	public PersonDTO findById(String identificationDocument) throws PersonNotFoundException {
		Person person = findPersonById(identificationDocument);
		return personMapper.toDTO(person);
	}

	private Person findPersonById(String identificationDocument) throws PersonNotFoundException {
		return repository.findById(identificationDocument)
				.orElseThrow(() -> new PersonNotFoundException(identificationDocument));
	}

	public PersonDTO update(String identificationDocument, @Valid PersonDTO personDTO) throws PersonNotFoundException {
		Person persistedPerson = findPersonById(identificationDocument);
		Person personToSave = personMapper.toModel(personDTO);
		BeanUtils.copyProperties(personToSave, persistedPerson);
		Person updatedPerson = repository.save(persistedPerson);
		return personMapper.toDTO(updatedPerson);
	}

}
