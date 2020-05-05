package pl.fulful.com.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.model.Vet;
import pl.fulful.com.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }
}
