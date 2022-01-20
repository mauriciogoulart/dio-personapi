package br.com.mg.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.mg.personapi.dto.PersonDTO;
import br.com.mg.personapi.entity.Person;

@Mapper
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	@Mapping(target = "birthDate", source="birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO personDTO);
	PersonDTO toDTO(Person person);

}
