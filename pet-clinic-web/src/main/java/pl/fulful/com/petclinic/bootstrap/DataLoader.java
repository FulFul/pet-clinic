package pl.fulful.com.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.fulful.com.petclinic.model.Owner;
import pl.fulful.com.petclinic.model.Vet;
import pl.fulful.com.petclinic.services.OwnerService;
import pl.fulful.com.petclinic.services.VetService;
import pl.fulful.com.petclinic.services.map.OwnerServiceMap;
import pl.fulful.com.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Michael2");
        owner2.setLastName("Weston2");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam2");
        vet2.setLastName("Axe2");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
