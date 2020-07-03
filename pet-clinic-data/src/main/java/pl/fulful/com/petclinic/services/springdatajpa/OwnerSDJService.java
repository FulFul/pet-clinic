package pl.fulful.com.petclinic.services.springdatajpa;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.dao.OwnerRepository;
import pl.fulful.com.petclinic.model.Owner;
import pl.fulful.com.petclinic.services.OwnerService;

import java.util.*;

@Service
@Profile("springdatajpa")
public class OwnerSDJService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
//        Set<Owner> owners = new HashSet<>();
//        ownerRepository.findAll().forEach(owners::add);
//        return owners;

        return Sets.newHashSet(ownerRepository.findAll());
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
