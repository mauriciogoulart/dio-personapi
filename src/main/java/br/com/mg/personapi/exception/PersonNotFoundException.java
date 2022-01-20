package br.com.mg.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = -220950167702121713L;

	public PersonNotFoundException(String identificationDocument) {
		super("Person with identification document " + identificationDocument + " not found");
	}
	
	

}
