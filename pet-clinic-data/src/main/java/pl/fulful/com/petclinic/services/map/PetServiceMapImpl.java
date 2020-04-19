package pl.fulful.com.petclinic.services.map;

import pl.fulful.com.petclinic.model.Pet;
import pl.fulful.com.petclinic.services.CrudService;

public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}
