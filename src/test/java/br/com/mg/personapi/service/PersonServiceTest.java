package br.com.mg.personapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.mg.personapi.dto.PersonDTO;
import br.com.mg.personapi.entity.Person;
import br.com.mg.personapi.mapper.PersonMapper;
import br.com.mg.personapi.repository.PersonRepository;
import br.com.mg.personapi.utils.PersonUtils;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	@Mock
	private PersonRepository repository;

	@InjectMocks
	private PersonService service;

	@Test
	void testGivenPersonDTOSave() {
		PersonDTO personDTO = PersonUtils.createDTO();
		Person expectedPerson = PersonUtils.create();
		Mockito.when(repository.save(expectedPerson)).thenReturn(expectedPerson);
		PersonDTO savedPerson = service.create(personDTO);
		assertEquals(personMapper.toDTO(expectedPerson), savedPerson);
	}

}