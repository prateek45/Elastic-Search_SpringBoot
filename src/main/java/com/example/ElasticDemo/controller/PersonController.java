package com.example.ElasticDemo.controller;

import com.example.ElasticDemo.entities.Person;
import com.example.ElasticDemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public void save (@RequestBody final Person person){
        service.save(person);
    }

    @PostMapping("/multiple")
    public int save (@RequestBody List<Person> persons){
        service.saveAll(persons);
        return  persons.size();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable final String id) {
        return service.findById(id);
    }
}
