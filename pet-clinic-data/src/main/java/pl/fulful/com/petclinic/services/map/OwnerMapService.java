package pl.fulful.com.petclinic.services.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.model.Owner;
import pl.fulful.com.petclinic.services.OwnerService;
import pl.fulful.com.petclinic.services.PetService;
import pl.fulful.com.petclinic.services.PetTypeService;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    @Autowired
    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    /**
     * Ta funkcja została nadpisana ... po co?
     *      - nie trzeba by jej w sumie było
     *      - ale jeśli stworzyłby ktoś PetType petType, następnie stworzył Pet dog, następnie Owner owner1 i zapisał
     *        owner1 (przypisując do niego Pet dog oraz ustawiając w dog PetType petType (ale nie zapisując wcześniej
     *        tych petType ani pet poprzez serwis.save() to wtedy zapisałby się owner, ale nie zapisałyby się pet ani
     *        petType
     *      - dlatego wlaśnie ta funkcja tu została dodana. Zapisując ownera od razu sprawdza czy ma pety i jeśli ma
     *        to każdego peta sprawdza czy ma petType - jeśli nie to rzuca wyjątkiem - nie do zaakceptowania. Jeśli
     *        ma petType ale petType nie ma id - nadaje mu go (zapisując serwis.save()) oraz sprawcza czy pet ma id
     *        jeśli nie ma to zapisuje go serwis.save() i tym sammym nadaje mu id.
     *      - TYLE - właśnie po to jest tu ta kombinacja
     *
     * @param owner
     * @return
     */
    @Override
    public Owner save(Owner owner) {

        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            petTypeService.save(pet.getPetType());
                        }
                    } else {
                        throw new RuntimeException("PetType cannot be null. Set proper PetType in your pet, please.");
                    }

                    if (pet.getId() == null) {
                        petService.save(pet);
                    }
                });
            }

            return super.save(owner);
        }

        return null;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
