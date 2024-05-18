package br.com.petspot.repository;

import br.com.petspot.model.entity.petOwner.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepository extends JpaRepository<PetOwner, String> {
}
