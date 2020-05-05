package pl.fulful.com.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.model.Pet;
import pl.fulful.com.petclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}
