package com.storageserverbackend.storageserverbackend.impl.categories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Integer> {

}
