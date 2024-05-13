package br.com.petspot.repository;

import br.com.petspot.model.Pet.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, String> {
    Page<Pet> findAllByPetOwners_Id(String id, Pageable pg);
}
