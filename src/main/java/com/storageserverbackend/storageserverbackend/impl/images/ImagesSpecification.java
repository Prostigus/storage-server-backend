package com.storageserverbackend.storageserverbackend.impl.images;

import com.storageserverbackend.storageserverbackend.impl.categories.Categories;
import com.storageserverbackend.storageserverbackend.impl.categories.Categories_;
import com.storageserverbackend.storageserverbackend.impl.person.Person;
import com.storageserverbackend.storageserverbackend.impl.person.Person_;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public class ImagesSpecification {

    private ImagesSpecification() {
    }

    public static Specification<Images> hasPeople(List<Integer> people) {
        return (root, query, builder) -> {
            Join<Images, Person> imagePerson = root.join(Images_.PEOPLE);

            return imagePerson.get(Person_.ID).in(people);
        };
    }

    public static Specification<Images> hasCategories(List<Integer> categories) {
        return (root, query, builder) -> {
            Join<Images, Categories> imageCategories = root.join(Images_.CATEGORIES);

            return imageCategories.get(Categories_.ID).in(categories);
        };
    }

    public static Specification<Images> hasFavourite() {
        return (root, query, builder) -> builder.equal(root.get(Images_.fav), true);
    }

}
