package pl.fulful.com.petclinic.dao;

import org.springframework.data.repository.CrudRepository;
import pl.fulful.com.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
