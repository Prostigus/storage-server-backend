package com.storageserverbackend.storageserverbackend.impl.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
