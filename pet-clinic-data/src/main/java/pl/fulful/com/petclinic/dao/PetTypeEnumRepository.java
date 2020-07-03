package pl.fulful.com.petclinic.dao;

import org.springframework.data.repository.CrudRepository;
import pl.fulful.com.petclinic.model.PetTypeEnum;

public interface PetTypeEnumRepository extends CrudRepository<PetTypeEnum, Long> {
}
