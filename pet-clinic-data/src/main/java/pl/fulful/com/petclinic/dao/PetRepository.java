package pl.fulful.com.petclinic.dao;

import org.springframework.data.repository.CrudRepository;
import pl.fulful.com.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
