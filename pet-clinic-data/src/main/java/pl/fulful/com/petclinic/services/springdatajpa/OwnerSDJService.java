package pl.fulful.com.petclinic.services.springdatajpa;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.dao.OwnerRepository;
import pl.fulful.com.petclinic.dao.PetRepository;
import pl.fulful.com.petclinic.dao.PetTypeRepository;
import pl.fulful.com.petclinic.model.Owner;
import pl.fulful.com.petclinic.services.OwnerService;
import pl.fulful.com.petclinic.services.PetService;
import pl.fulful.com.petclinic.services.PetTypeService;

import java.util.*;

@Service
@Profile("springdatajpa")
public class OwnerSDJService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerSDJService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
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
    public Owner save(Owner owner) {
        System.out.println("####################################################### OwnerSDJService.save()");

//        if (owner != null) {
//            owner.getPets().forEach(pet -> {
//                if (pet.getPetType() != null) {
//                    if (pet.getPetType().getId() == null) {
//                        petTypeService.save(pet.getPetType());
//                    }
//                } else {
//                    throw new RuntimeException("PetType cannot be null. Set proper PetType in your pet, please.");
//                }
//
//                if (pet.getId() == null) {
//                    petService.save(pet);
//                }
//            });
//
////            return super.save(owner);
            System.out.println("owner.getId() = " + owner.getId());
            System.out.println("owner.getFirstName() = " + owner.getFirstName());
            System.out.println("owner.getPets() = " + owner.getPets());
//            owner.setId(101L);
//            return ownerRepository.save(owner);
//        }
//
//        return null;
//
        return ownerRepository.save(owner);
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
