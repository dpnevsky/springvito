package com.example.springvito.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name="persons")
@Getter
@Setter
@NoArgsConstructor
public class Person implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nickname")
    @NotEmpty(message = "The field should not be empty")
    @Size(max = 25, message = "The field should be less than 25 characters")
    private String nickname;

    @Column(name = "password")
    @NotEmpty(message = "The field should not be empty")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "owner")
    private Set<Auto> autos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<PersonalItem> personalItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<Realty> realty = new LinkedHashSet<>();

    @Override
    public String toString() {
        return   "id=" + id + ", " + nickname;
    }
}
