package com.example.ElasticDemo.repository;

import com.example.ElasticDemo.entities.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonRepository extends ElasticsearchRepository<Person, String> {

}
