package pl.fulful.com.petclinic.dao;

import org.springframework.data.repository.CrudRepository;
import pl.fulful.com.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
