package com.app.peopleservice.controllers;

import com.app.peopleservice.model.Person;
import com.app.peopleservice.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PeopleService peopleService;

    @GetMapping("/all")
    public List<Person> getAll() {
        return peopleService.getAll();
    }

    @DeleteMapping("/remove/{id}")
    public Person deleteById(@PathVariable int id) {
        try {
            return peopleService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/get/{id}")
    public Person getOne(@PathVariable int id) {
        try {
            return peopleService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return peopleService.addPerson(person);
    }
}
