package br.com.mg.personapi.utils;

import java.time.LocalDate;
import java.util.List;

import br.com.mg.personapi.dto.PersonDTO;
import br.com.mg.personapi.dto.PhoneDTO;
import br.com.mg.personapi.entity.Person;
import br.com.mg.personapi.entity.Phone;
import br.com.mg.personapi.enums.PhoneType;

public class PersonUtils {

	public static Person create() {
		return Person.builder().birthDate(LocalDate.of(2020, 5, 21)).identificationDocument("199999932000").name("joao da silva")
				.phones(List.of(Phone.builder().number("48 99999983").type(PhoneType.MOBILE).build())).build();
	}
	public static PersonDTO createDTO() {
		return PersonDTO.builder().birthDate("21-05-2020").identificationDocument("199999932000").name("joao da silva")
				.phones(List.of(PhoneDTO.builder().number("48 99999983").type(PhoneType.MOBILE).build())).build();
	}
	

}