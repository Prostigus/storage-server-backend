package com.storageserverbackend.storageserverbackend.impl.links;

import com.storageserverbackend.storageserverbackend.impl.categories.Categories;
import com.storageserverbackend.storageserverbackend.impl.categories.Categories_;
import com.storageserverbackend.storageserverbackend.impl.person.Person;
import com.storageserverbackend.storageserverbackend.impl.person.Person_;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public class LinksSpecification {

    private LinksSpecification() {
    }

    public static Specification<Links> hasPeople(List<Integer> people) {
        return (root, query, builder) -> {
            Join<Links, Person> linksPerson = root.join(Links_.PEOPLE);

            return linksPerson.get(Person_.ID).in(people);
        };
    }

    public static Specification<Links> hasCategories(List<Integer> categories) {
        return (root, query, builder) -> {
            Join<Links, Categories> linksCategories = root.join(Links_.CATEGORIES);

            return linksCategories.get(Categories_.ID).in(categories);
        };
    }

    public static Specification<Links> hasFavourite() {
        return (root, query, builder) -> builder.equal(root.get(Links_.fav), true);
    }

}
