package pl.fulful.com.petclinic.services;

import pl.fulful.com.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
