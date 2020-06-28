package pl.fulful.com.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.fulful.com.petclinic.model.*;
import pl.fulful.com.petclinic.services.OwnerService;
import pl.fulful.com.petclinic.services.PetService;
import pl.fulful.com.petclinic.services.PetTypeService;
import pl.fulful.com.petclinic.services.VetService;

import java.time.LocalDate;
import java.util.HashSet;

/* ta klasa jest chyba tylko do testów - w sensie aby programując
   i dokładając kolejne cegiełki z modelu można było je na bierząco
   testować właśnie dodając je w tej klasie.

   CommandLineRunner - uruchamia metodę run() zaraz po kompilacji.
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

//        PetType dog = new PetType();
//        dog.setName("Dog");
//        PetType savedDogType = petTypeService.save(dog);                    // w tym miejscu nadawane jest ID dla PetType dog
//
//        PetType cat = new PetType();
//        dog.setName("Cat");
//        PetType savedCatType = petTypeService.save(cat);                    // w tym miejscu nadawane jest ID dla PetType cat
//
//        Pet petDog = new Pet();
//        petDog.setName("Kuli");
//        petDog.setBirthDate(LocalDate.of(2019, 12, 1));
//        petDog.setPetTypeEnum(PetTypeEnum.DOG);
//        petDog.setPetType(savedDogType);
//        Pet savedPetDog = petService.save(petDog);                            // w tym miejscu nadawane jest ID dla petDog
//
//        Pet petCat = new Pet();
//        petCat.setName("Bączek");
//        petCat.setBirthDate(LocalDate.of(2019, 12, 1));
//        petCat.setPetTypeEnum(PetTypeEnum.CAT);
//        petCat.setPetType(savedCatType);
//        Pet savedPetCat = petService.save(petCat);                            // w tym miejscu nadawane jest ID dla petCat
//
//        Owner owner1 = new Owner();
//        owner1.setFirstName("Michael");
//        owner1.setLastName("Weston");
//        owner1.setAddress("Wallenroda");
//        owner1.setCity("Krakow");
//        owner1.setTelephone("2344342342");
//        savedPetDog.setOwner(owner1);
//        owner1.getPets().add(savedPetDog);
//        ownerService.save(owner1);                                          // w tym miejscu nadawane jest ID dla owner1
//
//        Owner owner2 = new Owner();
//        owner2.setFirstName("Michael2");
//        owner2.setLastName("Weston2");
//        owner2.setAddress("Wallenroda2");
//        owner2.setCity("Krakow2");
//        owner2.setTelephone("233424265562");
//        savedPetCat.setOwner(owner2);
//        owner2.getPets().add(savedPetCat);
//        ownerService.save(owner2);                                          // w tym miejscu nadawane jest ID dla owner2

        System.out.println("Loaded Owners...");


        PetType dog2 = new PetType();
        dog2.setName("Dog2");

        Pet petDog2 = new Pet();
        petDog2.setName("Kuli2");
        petDog2.setBirthDate(LocalDate.of(2019, 12, 1));
        petDog2.setPetTypeEnum(PetTypeEnum.DOG);
        petDog2.setPetType(dog2);

        Owner owner10 = new Owner();
        owner10.setFirstName("Michael");
        owner10.setLastName("Weston");
        owner10.setAddress("Wallenroda");
        owner10.setCity("Krakow");
        owner10.setTelephone("2344342342");
        petDog2.setOwner(owner10);
        owner10.getPets().add(petDog2);
        ownerService.save(owner10);                                          // w tym miejscu nadawane jest ID dla owner1

        Owner[] owners = new Owner[100];
        Pet[] pets = new Pet[100];
        System.out.println("petTypeService.findAll() = " + petTypeService.findAll());
        System.out.println("petService.findAll() = " + petService.findAll());
        System.out.println("ownerService.findAll()[0].id = " + ownerService.findAll().toArray(owners)[0].getId());
        System.out.println("---------");
        System.out.println("owner10.pets[0].name = " + ownerService.findAll().toArray(owners)[0].getPets().toArray(pets)[0].getName());
        System.out.println("owner10.pets[0].id = " + ownerService.findAll().toArray(owners)[0].getPets().toArray(pets)[0].getId());
        System.out.println("owner10.pets[0].petType = " + ownerService.findAll().toArray(owners)[0].getPets().toArray(pets)[0].getPetType().getName());
        System.out.println("owner10.pets[0].petType.id = " + ownerService.findAll().toArray(owners)[0].getPets().toArray(pets)[0].getPetType().getId());


//        Vet vet1 = new Vet();
//        vet1.setFirstName("Sam");
//        vet1.setLastName("Axe");
//        vetService.save(vet1);
//
//        Vet vet2 = new Vet();
//        vet2.setFirstName("Sam2");
//        vet2.setLastName("Axe2");
//        vetService.save(vet2);
//
//        System.out.println("Loaded Vets...");
    }
}
