package com.app.peopleservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class People {
    private List<Person> persons = new ArrayList<>();

    public People(){
        persons.add(Person.builder().id(1).age(12).name("Kuba").surname("Musial").build());
        persons.add(Person.builder().id(2).age(43).name("Kacper").surname("Dudek").build());
        persons.add(Person.builder().id(3).age(32).name("Marek").surname("Nowak").build());
    }
}
