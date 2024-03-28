package com.storageserverbackend.storageserverbackend.impl.images;

import com.storageserverbackend.storageserverbackend.impl.base.BaseMedia;
import com.storageserverbackend.storageserverbackend.impl.categories.Categories;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "images")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Images extends BaseMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String img;

    @Setter
    @Getter
    private String uploadPath;

    @Setter
    @Getter
    private String extension;
    
    private Images() {
    }

    public Images(String uuid, String description, String img, boolean fav, Set<Categories> categories) {
        super(uuid, description, fav);
        this.img = img;
    }

}

