package br.com.petinfo.repository;

import br.com.petinfo.model.entity.Pet.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lincoln
 */
public interface VaccineRepository extends JpaRepository<Vaccine, String> {
}
