package com.storageserverbackend.storageserverbackend.impl.enthnicity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ethnicity")
public class Ethnicity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter
    @Getter
    private String race;

    private Ethnicity() {
    }

    public Ethnicity(String race) {
        this.race = race;
    }

    public Integer getId() {
        return this.id;
    }
}
