package br.com.petspot.model.entity.tutors;

import br.com.petspot.model.entity.Pet.Pet;
import br.com.petspot.model.entity.login.Login;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String idPerson;

    private String namePerson;

    private String surnamePerson;

    private Integer numberCell;

    private String nationalityPerson;

    @OneToOne(mappedBy = "personLogin")
    private Login logins;

    @OneToOne
    private PetOwner petOwner;

    @ManyToMany
    @JoinTable(name = "pets_tutor",
            joinColumns = @JoinColumn(name = "pets_tutor"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private Set<Pet> pet = new HashSet<>();


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Person person = (Person) o;
        return getIdPerson() != null && Objects.equals(getIdPerson(), person.getIdPerson());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}