package com.app.peopleservice.service;

import com.app.peopleservice.model.People;
import com.app.peopleservice.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PeopleService {
    private People people = new People();

    public List<Person> getAll() {
        log.info("Getting all persons");
        System.out.println(people.getPersons());
        return people.getPersons();
    }

    public Person addPerson(Person person) {
        log.info("Adding person: " + person);
        people.getPersons().add(person);
        return person;
    }

    public Person findById(int id) throws Exception {
        log.info("Finding person by id: " + id);
        List<Person> filtered = people.getPersons().stream()
                .filter(p -> p.getId() == id)
                .collect(Collectors.toList());

        if (filtered.size() == 1) {
            System.out.println(filtered.get(0));
            return filtered.get(0);
        }
        log.error("Found the same id's or any id");
        throw new Exception("wynik ma wiecej elementow niz jeden");
    }

    public Person deleteById(int id) throws Exception {
        log.info("deleteing by id: " + id);
        Person delete = findById(id);
        System.out.println(delete);
        people.getPersons().remove(delete);
        return delete;
    }
}
