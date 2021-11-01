package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, Integer> {
    Optional<Person> findPersonById(Integer id);

}
