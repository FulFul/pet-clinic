package pl.fulful.com.petclinic.services.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.model.Vet;
import pl.fulful.com.petclinic.services.SpecialityService;
import pl.fulful.com.petclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityService;

    @Autowired
    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet vet) {

        if (vet != null) {
            if (vet.getSpecialities() != null) {
                vet.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        specialityService.save(speciality);
                    }
                });
            } else {
                throw new RuntimeException("Vet should have at least one speciality!");
            }

            return super.save(vet);
        }

        return null;
    }
}
