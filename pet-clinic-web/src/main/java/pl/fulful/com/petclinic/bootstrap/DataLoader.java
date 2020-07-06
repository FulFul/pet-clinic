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
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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
//        Pet savedPetDog = petService.save(petDog);                            // w tym miejscu nadawane jest ID dla petDog

        Pet petCat = new Pet();
        petCat.setName("Bączek");
        petCat.setBirthDate(LocalDate.of(2019, 12, 1));
        petCat.setPetTypeEnum(PetTypeEnum.CAT);
        petCat.setPetType(savedCatType);
//        Pet savedPetCat = petService.save(petCat);                            // w tym miejscu nadawane jest ID dla petCat

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Wallenroda");
        owner1.setCity("Krakow");
        owner1.setTelephone("2344342342");
        petDog.setOwner(owner1);
        owner1.getPets().add(petDog);
        ownerService.save(owner1);                                          // w tym miejscu nadawane jest ID dla owner1

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael2");
        owner2.setLastName("Weston2");
        owner2.setAddress("Wallenroda2");
        owner2.setCity("Krakow2");
        owner2.setTelephone("233424265562");
        petCat.setOwner(owner2);
        owner2.getPets().add(petCat);
        ownerService.save(owner2);                                          // w tym miejscu nadawane jest ID dla owner2

        Owner owner3 = Owner.builder()
                .firstName("elo")
                .lastName("okoko")
                .address("kkkkk")
                .city("llll")
                .telephone("908098")
                .build();

        ownerService.save(owner3);
        System.out.println("owner3 = " + owner3);
        System.out.println("owner3.getId() = " + owner3.getId());
        System.out.println("owner3.getFName() = " + owner3.getFirstName());
        System.out.println("owner3.getLastName() = " + owner3.getLastName());


        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("wizyta hello");
        visit.setPet(petCat);
        System.out.println("PRZED         visitService.save(visit);");
        visitService.save(visit);

        Speciality jelenSpeciality = new Speciality();
        jelenSpeciality.setDescription("Badacz jeleni");

        Speciality wiewiorSpeciality = new Speciality();
        wiewiorSpeciality.setDescription("Badacz wiewiór");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(jelenSpeciality);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam2");
        vet2.setLastName("Axe2");
        vet2.getSpecialities().add(wiewiorSpeciality);
        vetService.save(vet2);
    }
}
