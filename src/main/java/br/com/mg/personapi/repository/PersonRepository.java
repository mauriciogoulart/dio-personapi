package br.com.mg.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mg.personapi.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

}
