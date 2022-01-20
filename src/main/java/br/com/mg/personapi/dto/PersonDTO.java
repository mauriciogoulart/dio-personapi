package br.com.mg.personapi.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

	@Size(min=8, max = 20)
	private String identificationDocument;

	@Size(min=2, max = 200)
	private String name;

	private String birthDate;

	@Valid
	private List<PhoneDTO> phones;

}
