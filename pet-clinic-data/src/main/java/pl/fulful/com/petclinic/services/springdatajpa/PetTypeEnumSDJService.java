package pl.fulful.com.petclinic.services.springdatajpa;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.dao.PetTypeEnumRepository;
import pl.fulful.com.petclinic.model.PetTypeEnum;
import pl.fulful.com.petclinic.services.PetTypeEnumService;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeEnumSDJService implements PetTypeEnumService {
    
    private final PetTypeEnumRepository petTypeEnumRepository;

    public PetTypeEnumSDJService(PetTypeEnumRepository petTypeEnumRepository) {
        this.petTypeEnumRepository = petTypeEnumRepository;
    }

    @Override
    public Set<PetTypeEnum> findAll() {
        return Sets.newHashSet(petTypeEnumRepository.findAll());
    }

    @Override
    public PetTypeEnum findById(Long aLong) {
        return petTypeEnumRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetTypeEnum save(PetTypeEnum object) {
        return petTypeEnumRepository.save(object);
    }

    @Override
    public void delete(PetTypeEnum object) {
        petTypeEnumRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeEnumRepository.deleteById(aLong);
    }
}
