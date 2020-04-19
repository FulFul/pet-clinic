package pl.fulful.com.petclinic.services.map;

import pl.fulful.com.petclinic.model.Vet;
import pl.fulful.com.petclinic.services.CrudService;

public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }
}
