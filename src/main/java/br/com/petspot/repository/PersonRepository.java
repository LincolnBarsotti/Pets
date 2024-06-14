package br.com.petspot.repository;

import br.com.petspot.model.entity.tutors.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}