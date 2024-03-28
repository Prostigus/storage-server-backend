package com.storageserverbackend.storageserverbackend.impl.videos;

import com.storageserverbackend.storageserverbackend.impl.categories.Categories;
import com.storageserverbackend.storageserverbackend.impl.categories.Categories_;
import com.storageserverbackend.storageserverbackend.impl.person.Person;
import com.storageserverbackend.storageserverbackend.impl.person.Person_;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public class VideosSpecification {

    private VideosSpecification() {
    }

    public static Specification<Videos> hasPeople(List<Integer> people) {
        return (root, query, builder) -> {
            Join<Videos, Person> videosPerson = root.join(Videos_.PEOPLE);

            return videosPerson.get(Person_.ID).in(people);
        };
    }

    public static Specification<Videos> hasCategories(List<Integer> categories) {
        return (root, query, builder) -> {
            Join<Videos, Categories> videosCategories = root.join(Videos_.CATEGORIES);

            return videosCategories.get(Categories_.ID).in(categories);
        };
    }

    public static Specification<Videos> hasFavourite() {
        return (root, query, builder) -> builder.equal(root.get(Videos_.fav), true);
    }

}
