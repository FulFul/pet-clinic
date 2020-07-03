package pl.fulful.com.petclinic.dao;

import org.springframework.data.repository.CrudRepository;
import pl.fulful.com.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
