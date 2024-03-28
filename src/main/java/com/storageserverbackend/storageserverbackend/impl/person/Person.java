package com.storageserverbackend.storageserverbackend.impl.person;

import com.storageserverbackend.storageserverbackend.impl.enthnicity.Ethnicity;
import com.storageserverbackend.storageserverbackend.impl.images.Images;
import com.storageserverbackend.storageserverbackend.impl.videos.Videos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter
    @Getter
    private String firstName;

    @Setter
    @Getter
    private String lastName;

    @Setter
    @Getter
    @ManyToOne
    private Ethnicity ethnicity;

    @ManyToMany(mappedBy = "people")
    private Set<Images> images;

    @ManyToMany(mappedBy = "people")
    private Set<Videos> videos;

    private Person() {
    }

    public Person(String firstName, String lastName, Ethnicity ethnicity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ethnicity = ethnicity;
    }

}
