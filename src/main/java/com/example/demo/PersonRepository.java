package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;


import java.util.Optional;


public interface PersonRepository extends MongoRepository<Person, String> {
    Person findPersonById(@Param("name") Integer id);


}
