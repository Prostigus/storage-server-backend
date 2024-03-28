package com.storageserverbackend.storageserverbackend.api.controller;

import com.storageserverbackend.storageserverbackend.impl.person.IPersonService;
import com.storageserverbackend.storageserverbackend.impl.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {
    @Autowired
    private IPersonService personService;

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/person")
    public List<Person> getPersonList() {
        return personService.fetchList();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable String id) {
        return personService.fetchById(Integer.parseInt(id));
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable String id, @RequestBody Person person) {
        return personService.update(person, Integer.parseInt(id));
    }


}
