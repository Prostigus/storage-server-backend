package com.storageserverbackend.storageserverbackend.impl.base;

import com.storageserverbackend.storageserverbackend.impl.categories.Categories;
import com.storageserverbackend.storageserverbackend.impl.person.Person;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@MappedSuperclass
public class BaseMedia {
    private UUID uuid;

    private String description;

    private boolean fav;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable()
    private Set<Categories> categories;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable()
    private Set<Person> people;

    public BaseMedia() {
    }

    public BaseMedia(String uuid, String description, boolean fav) {
        this.uuid = UUID.fromString(uuid);
        this.description = description;
        this.fav = fav;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public void setUUID(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean getFav() {
        return this.fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

}
