package pl.fulful.com.petclinic.services.springdatajpa;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.dao.SpecialityRepository;
import pl.fulful.com.petclinic.model.Speciality;
import pl.fulful.com.petclinic.services.SpecialityService;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJService implements SpecialityService {
    
    private final SpecialityRepository specialityRepository;

    public SpecialitySDJService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        return Sets.newHashSet(specialityRepository.findAll());
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
