package pl.fulful.com.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.model.Owner;
import pl.fulful.com.petclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
