package pl.fulful.com.petclinic.services.map;

import pl.fulful.com.petclinic.model.Vet;
import pl.fulful.com.petclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }
}
