package br.com.mg.personapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mg.personapi.dto.PersonDTO;
import br.com.mg.personapi.entity.Person;
import br.com.mg.personapi.mapper.PersonMapper;
import br.com.mg.personapi.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	public List<PersonDTO> findAll() {
		List<Person> people = repository.findAll();
		List<PersonDTO> peopleDTO = people.stream().map(personMapper::toDTO)
				.collect(Collectors.toList());
		return peopleDTO;
	}

	public PersonDTO save(PersonDTO personDTO) {
		Person person = personMapper.toModel(personDTO);
		repository.save(person);
		return personMapper.toDTO(person);
	}

}
