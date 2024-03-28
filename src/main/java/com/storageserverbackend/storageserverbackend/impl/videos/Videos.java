package com.storageserverbackend.storageserverbackend.impl.videos;

import com.storageserverbackend.storageserverbackend.impl.base.BaseMedia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "videos")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Videos extends BaseMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter
    @Getter
    private String video;

    @Setter
    @Getter
    private String uploadPath;

    @Setter
    @Getter
    private String extension;

    private Videos() {
    }

    public Videos(String uuid, String description, String video, boolean fav) {
        super(uuid, description, fav);
        this.video = video;
    }


}
