package pl.fulful.com.petclinic.services.springdatajpa;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.dao.PetTypeRepository;
import pl.fulful.com.petclinic.model.PetType;
import pl.fulful.com.petclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        return Sets.newHashSet(petTypeRepository.findAll());
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
