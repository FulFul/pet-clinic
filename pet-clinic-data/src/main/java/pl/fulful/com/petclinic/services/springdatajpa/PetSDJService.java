package pl.fulful.com.petclinic.services.springdatajpa;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.dao.PetRepository;
import pl.fulful.com.petclinic.model.Pet;
import pl.fulful.com.petclinic.services.PetService;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJService implements PetService {

    private final PetRepository petRepository;

    public PetSDJService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        return Sets.newHashSet(petRepository.findAll());
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
