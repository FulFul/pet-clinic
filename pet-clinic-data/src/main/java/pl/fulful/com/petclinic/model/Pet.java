package pl.fulful.com.petclinic.model;

import java.time.LocalDate;

public class Pet {
    private PetType petType;
    private PetTypeEnum petTypeEnum;
    private Owner owner;
    private LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetTypeEnum getPetTypeEnum() {
        return petTypeEnum;
    }

    public void setPetTypeEnum(PetTypeEnum petTypeEnum) {
        this.petTypeEnum = petTypeEnum;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
