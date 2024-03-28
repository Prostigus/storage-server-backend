package com.storageserverbackend.storageserverbackend.impl.categories;

import com.storageserverbackend.storageserverbackend.impl.images.Images;
import com.storageserverbackend.storageserverbackend.impl.links.Links;
import com.storageserverbackend.storageserverbackend.impl.videos.Videos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Categories {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    private String category;

    @Getter
    @Setter
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Images> images;

    @ManyToMany(mappedBy = "categories")
    private Set<Links> links;

    @ManyToMany(mappedBy = "categories")
    private Set<Videos> videos;

    private Categories() {
    }

    public Categories(String category, String description) {
        this.category = category;
        this.description = description;
    }
    
}
