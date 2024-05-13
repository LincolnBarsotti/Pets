package br.com.petspot.repository;

import br.com.petspot.model.Pet.Pet;
import br.com.petspot.model.petOwner.PetOwner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PetOwnerRepository extends JpaRepository<PetOwner, String> {
}
