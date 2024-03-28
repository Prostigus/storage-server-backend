package com.storageserverbackend.storageserverbackend.impl.person;

import java.util.List;


public interface IPersonService {
    Person save(Person person);

    List<Person> fetchList();

    Person fetchById(Integer peopleId);

    Person update(Person person, Integer peopleId);

    void delete(Integer peopleId);
}
