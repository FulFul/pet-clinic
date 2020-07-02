package pl.fulful.com.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets = new HashSet<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addVet(Vet vet) {
        // TODO: nie jestem pewien czy to poniżej jest konieczne
        vet.addSpeciality(this);
        this.vets.add(vet);
    }
}
