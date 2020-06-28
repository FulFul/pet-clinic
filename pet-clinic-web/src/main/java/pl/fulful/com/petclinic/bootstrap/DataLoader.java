package pl.fulful.com.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.fulful.com.petclinic.model.*;
import pl.fulful.com.petclinic.services.*;

import java.time.LocalDate;

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
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = ownerService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        // -----------------------
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);                    // w tym miejscu nadawane jest ID dla PetType dog

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);                    // w tym miejscu nadawane jest ID dla PetType cat

        Pet petDog = new Pet();
        petDog.setName("Kuli");
        petDog.setBirthDate(LocalDate.of(2019, 12, 1));
        petDog.setPetTypeEnum(PetTypeEnum.DOG);
        petDog.setPetType(savedDogType);
        Pet savedPetDog = petService.save(petDog);                            // w tym miejscu nadawane jest ID dla petDog

        Pet petCat = new Pet();
        petCat.setName("Bączek");
        petCat.setBirthDate(LocalDate.of(2019, 12, 1));
        petCat.setPetTypeEnum(PetTypeEnum.CAT);
        petCat.setPetType(savedCatType);
        Pet savedPetCat = petService.save(petCat);                            // w tym miejscu nadawane jest ID dla petCat

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Wallenroda");
        owner1.setCity("Krakow");
        owner1.setTelephone("2344342342");
        savedPetDog.setOwner(owner1);
        owner1.getPets().add(savedPetDog);
        ownerService.save(owner1);                                          // w tym miejscu nadawane jest ID dla owner1

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael2");
        owner2.setLastName("Weston2");
        owner2.setAddress("Wallenroda2");
        owner2.setCity("Krakow2");
        owner2.setTelephone("233424265562");
        savedPetCat.setOwner(owner2);
        owner2.getPets().add(savedPetCat);
        ownerService.save(owner2);                                          // w tym miejscu nadawane jest ID dla owner2

        System.out.println("----------");
        Owner[] owners = new Owner[100];
        Pet[] pets = new Pet[100];
        System.out.println("owner1.pet.name = " +    ownerService.findAll().toArray(owners)[0].getPets().toArray(pets)[0].getName());
        System.out.println("owner1.pet.id = " +      ownerService.findAll().toArray(owners)[0].getPets().toArray(pets)[0].getId());
        System.out.println("owner1.pet.type = " +    ownerService.findAll().toArray(owners)[0].getPets().toArray(pets)[0].getPetType().getName());
        System.out.println("owner1.pet.type_id = " + ownerService.findAll().toArray(owners)[0].getPets().toArray(pets)[0].getPetType().getId());
        System.out.println("----------");

        // -----------------------

        PetType bigDog = new PetType();
        bigDog.setName("Big DOG");

        Pet bigDogPet = new Pet();
        bigDogPet.setName("Big DOG dogerMAN");
        bigDogPet.setBirthDate(LocalDate.of(2019, 12, 1));
        bigDogPet.setPetTypeEnum(PetTypeEnum.DOG);
        bigDogPet.setPetType(bigDog);

        Owner owner10 = new Owner();
        owner10.setFirstName("Michael");
        owner10.setLastName("Weston");
        owner10.setAddress("Wallenroda");
        owner10.setCity("Krakow");
        owner10.setTelephone("2344342342");
        bigDogPet.setOwner(owner10);
        owner10.getPets().add(bigDogPet);
        ownerService.save(owner10);                                         // w tym miejscu nadawane jest ID dla:
                                                                            //     - PetType bigDog
                                                                            //     - Pet bigDogPet
                                                                            //     - Owner owner10
                                                                            // za sprawą modyfikacji w OwnerMapSerwice
                                                                            // a konkretnie implementacji save()
                                                                            // sprawdzałem i wszystkie id się zapisały
        System.out.println("----------");
        System.out.println("owner10.pet.name = " +    ownerService.findAll().toArray(owners)[2].getPets().toArray(pets)[0].getName());
        System.out.println("owner10.pet.id = " +      ownerService.findAll().toArray(owners)[2].getPets().toArray(pets)[0].getId());
        System.out.println("owner10.pet.type = " +    ownerService.findAll().toArray(owners)[2].getPets().toArray(pets)[0].getPetType().getName());
        System.out.println("owner10.pet.type_id = " + ownerService.findAll().toArray(owners)[2].getPets().toArray(pets)[0].getPetType().getId());
        System.out.println("Loaded Owners...");
        System.out.println("----------");

        Speciality jelenSpeciality = new Speciality();
        jelenSpeciality.setDescription("Badacz jeleni");
        Speciality savedSpeciality = specialityService.save(jelenSpeciality);           //  w tym miejscu nadawane jest ID dla jelenSpeciality

        Speciality wiewiorSpeciality = new Speciality();
        wiewiorSpeciality.setDescription("Badacz wiewiór");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedSpeciality);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam2");
        vet2.setLastName("Axe2");
        vet2.getSpecialities().add(wiewiorSpeciality);
        vetService.save(vet2);

        System.out.println("----------");
        Speciality[] specialities = new Speciality[100];
        System.out.println("vet1.speciality = " + vet1.getSpecialities().toArray(specialities)[0].getDescription());
        System.out.println("vet1.speciality_id = " + vet1.getSpecialities().toArray(specialities)[0].getId());
        System.out.println("vet2.speciality = " + vet2.getSpecialities().toArray(specialities)[0].getDescription());
        System.out.println("vet2.speciality_id = " + vet2.getSpecialities().toArray(specialities)[0].getId());
        System.out.println("----------");

        System.out.println("Loaded Vets...");
    }
}
