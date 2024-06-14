package br.com.petspot.model.entity.tutors;

import br.com.petspot.model.dto.logindto.RegisterUserDto;
import br.com.petspot.model.entity.Pet.Pet;
import br.com.petspot.model.entity.login.Login;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"idPerson"})
public class Person {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String idPerson;

    private String namePerson;

    private String surnamePerson;

    private Integer numberCell;

    private String nationalityPerson;

    private LocalDate birthdayPerson;

    @OneToOne(mappedBy = "personLogin")
    private Login logins;

    @ManyToMany
    @JoinTable(name = "pets_tutor",
            joinColumns = @JoinColumn(name = "tutor_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private Set<Pet> pet = new HashSet<>();

    public Person(RegisterUserDto registerUserDto) {
        this.namePerson = registerUserDto.name();
        this.surnamePerson = registerUserDto.surname();
        this.birthdayPerson = registerUserDto.getDate();
    }
}