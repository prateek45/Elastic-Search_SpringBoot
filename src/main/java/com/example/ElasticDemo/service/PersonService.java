package com.example.ElasticDemo.service;

import com.example.ElasticDemo.entities.Person;
import com.example.ElasticDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public void save(final Person person) {
        repository.save(person);
    }

    public Person findById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public void saveAll(List<Person> persons) {
        repository.saveAll(persons);
    }
}
