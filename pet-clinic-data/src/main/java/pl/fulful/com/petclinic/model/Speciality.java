package pl.fulful.com.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets = new HashSet<>();

    public void addVet(Vet vet) {
        // TODO: nie jestem pewien czy to poniżej jest konieczne
        vet.addSpeciality(this);
        this.vets.add(vet);
    }
}
