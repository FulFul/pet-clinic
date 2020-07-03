package pl.fulful.com.petclinic.dao;

import org.springframework.data.repository.CrudRepository;
import pl.fulful.com.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
