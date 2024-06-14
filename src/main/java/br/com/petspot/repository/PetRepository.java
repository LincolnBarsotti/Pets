package br.com.petspot.repository;

import br.com.petspot.model.entity.Pet.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {
    Page<Pet> findAllByPersonIdPerson(String id, Pageable pg);
}
