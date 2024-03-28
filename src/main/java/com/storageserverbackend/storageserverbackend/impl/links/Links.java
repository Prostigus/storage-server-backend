package com.storageserverbackend.storageserverbackend.impl.links;

import com.storageserverbackend.storageserverbackend.impl.base.BaseMedia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "links")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Links extends BaseMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter
    @Getter
    private String link;

    private Links() {
    }

    public Links(String link, String description, boolean fav) {
        super(null, description, fav);
        this.link = link;
    }
}
