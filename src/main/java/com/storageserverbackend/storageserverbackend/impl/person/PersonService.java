package com.storageserverbackend.storageserverbackend.impl.person;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Setter
@Data
@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> fetchList() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person fetchById(Integer person) {
        return personRepository.findById(person).get();
    }

    @Override
    public Person update(Person person, Integer personId) {
        Person personDB = personRepository.findById(personId).get();

        if (Objects.nonNull(person.getFirstName()) && !"".equalsIgnoreCase(person.getFirstName())) {
            personDB.setFirstName(person.getFirstName());
        }

        if (Objects.nonNull(person.getLastName()) && !"".equalsIgnoreCase(person.getLastName())) {
            personDB.setLastName(person.getLastName());
        }

        if (Objects.nonNull(person.getEthnicity())) {
            personDB.setEthnicity(person.getEthnicity());
        }

        return personRepository.save(personDB);
    }

    @Override
    public void delete(Integer personId) {
        personRepository.deleteById(personId);
    }

}
