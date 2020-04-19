package pl.fulful.com.petclinic.services.map;

import pl.fulful.com.petclinic.model.Owner;
import pl.fulful.com.petclinic.services.CrudService;

public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }
}
