package br.com.petinfo.repository;

import br.com.petinfo.model.entity.tutors.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}